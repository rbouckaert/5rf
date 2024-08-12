# 5rf

[BEAST 2](http://beast2.org) package for the Rate Class Root Frequency Model


## Install through BEAUti

# Installing the package

5rf is a [BEAST2](http://beast2.org) package that requires BEAST 2 v2.7.
If you have not already done so, you can get BEAST 2 from [here](http://beast2.org).

To install 5rf, it is easiest to start BEAUti (a program that is part of BEAST), and select the menu `File/Manage packages`. A package manager dialog pops up, that looks something like this:

![Package Manager](https://github.com/CompEvol/CCD/raw/master/doc/package_repos.png)

If the 5rf package is listed, just click on it to select it, and hit the `Install/Upgrade` button.

If the 5rf package is not listed, you may need to add a package repository by clicking the `Package repositories` button. A window pops up where you can click `Add URL` and add `https://raw.githubusercontent.com/CompEvol/CBAN/master/packages-extra-2.7.xml` in the entry. After clicking OK, the dialog should look something like this:

![Package Repositories](https://github.com/CompEvol/CCD/raw/master/doc/package_repos0.png)

Click OK and now 5rf should be listed in the package manager (as in the first dialog above). Select and click Install/Upgrade to install.



## Install by hand

* Download the package from [here](https://github.com/rbouckaert/5rf/releases/download/v0.0.1/5rf.package.v0.0.1.zip)
* Create 5rf directory inside BEAST package directory
  * for Windows in Users\<YourName>\BEAST\2.X\5rf
  * for Mac in /Users/<YourName>\/Library/Application Support/BEAST/2.X/5rf
  * for Linux /home/<YourName>/.beast/2.X/5rf
  Here <YourName> is the username you use, and in “2.X” the X refers to the major version of BEAST, so 2.X=2.7 for version 2.7.6.
* Unzip the file `5rf.package.v0.0.1.zip` inside the 5rf directory

## Build from code

* Get code for beast2, BeastFX and CCD repositories:
  * git clone https://github.com/CompEvol/beast2.git
  * git clone https://github.com/CompEvol/BeastFX.git
  * git clone https://github.com/rbouckaert/5rf.git
* Run `ant install` from the 5rf directory
  
## Usage

There is no BEAUti support yet, so you have to edit the XML by hand: see [annotated example](https://github.com/rbouckaert/5rf/raw/master/examples/test5rf.xml) file for details.