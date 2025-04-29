package fiverf.substitutionmodel;


import java.util.ArrayList;
import java.util.List;

import beast.base.core.BEASTInterface;
import beast.base.core.Input;
import beast.base.core.Log;
import beast.base.core.Input.Validate;
import beast.base.evolution.datatype.DataType;
import beast.base.evolution.sitemodel.SiteModel;
import beast.base.evolution.substitutionmodel.EigenDecomposition;
import beast.base.evolution.substitutionmodel.SubstitutionModel;
import beast.base.evolution.tree.Node;
import beast.base.inference.CalculationNode;


public class MixtureSubstitutionModel extends CalculationNode implements SubstitutionModel {
	final public Input<List<SubstitutionModel>> mixtureComponentInput = 
            new Input<>("component", "set of substitution models along branches in the beast.tree", new ArrayList<>(), Validate.REQUIRED);

	protected List<SubstitutionModel> mixtureComponent;
	private int invarCategoryOffset;
	
	@Override
	public void initAndValidate() {
		mixtureComponent = mixtureComponentInput.get();
		
        boolean forceJava = Boolean.valueOf(System.getProperty("java.only"));
        if (!forceJava) {
        	Log.warning("=============================================================");
        	Log.warning("== WARNING: MixtureSiteModel does not work with BEAGLE     ==");
        	Log.warning("== WARNING: Turn off BEAGLE using the -java flag for BEAST ==");
        	Log.warning("=============================================================");
        	throw new RuntimeException();
        }
        
        invarCategoryOffset = 0;
        for (BEASTInterface o : getOutputs()) {
        	if (o instanceof SiteModel sm) {
        		if (sm.invarParameterInput.get().getValue() > 0) {
        			invarCategoryOffset = 1;
        			Log.warning("Found invariable category in site model");
        		}
        	}
        }
	}
	
	
    
    private int category = 0;
        
    @Override
	public void getTransitionProbabilities(Node node, double startTime, double endTime, double rate,
			double[] matrix) {
		mixtureComponent.get(invarCategoryOffset + category).getTransitionProbabilities(node, startTime, endTime, rate, matrix);
		category = (category + 1 ) %  (mixtureComponent.size() - invarCategoryOffset);
	}
	
	public List<SubstitutionModel> getMixtureComponents() {
		return mixtureComponent;
	}
	
	@Override	
	public boolean canReturnComplexDiagonalization() {
		return true;
	}

	@Override
	public double[] getRateMatrix(Node node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double[] getFrequencies() {
		throw new RuntimeException("Frequencies for the model are not specified.\n"
				+ "This model should be used with fiverf.likelihood.TreeLikelihoodF.");
	}

	@Override
	public int getStateCount() {		
		return mixtureComponent.get(0).getStateCount();
	}

	@Override
	public EigenDecomposition getEigenDecomposition(Node node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean canHandleDataType(DataType dataType) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
