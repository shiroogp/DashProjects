# SonarQube Folder Exclusions Guide

## Overview
This guide explains how to disable SonarQube analysis on specific folders in your Dash project.

## Configuration File
The `sonar-project.properties` file has been created with common exclusions already configured.

## How to Exclude a Specific Folder

### Method 1: Edit sonar-project.properties
1. Open `sonar-project.properties`
2. Find the `sonar.exclusions` section
3. Add your folder to the exclusion list:

```properties
sonar.exclusions=\
    **/.idea/**,\
    **/.vscode/**,\
    **/your_folder_name/**,\
    # ... other exclusions
```

### Method 2: Exclude Multiple Folders
To exclude multiple folders at once:

```properties
sonar.exclusions=\
    **/BoostedDash/**,\
    **/PowerTune-master/**,\
    **/pyobd-pi/**,\
    **/mypis/**,\
    **/pibackup/**
```

### Method 3: Pattern-Based Exclusions
You can use patterns to exclude folders:

```properties
# Exclude all folders starting with "test"
**/test*/**

# Exclude all backup folders
**/*backup*/**

# Exclude specific file types
**/*.log,**/*.tmp
```

## Common Folders Already Excluded
The configuration already excludes:
- `.idea/` - IDE files
- `.vscode/` - VS Code settings
- `venv/` - Python virtual environments
- `pibackup/` - Backup folders
- `VMFiles/` - Virtual machine files
- `GhostDash.apk_Decompiler.com/` - Decompiled files
- Build artifacts (*.zip, *.apk, *.jar, etc.)

## Usage
1. Run SonarQube analysis from the project root
2. The exclusions will automatically apply
3. Excluded folders won't appear in SonarQube reports

## Examples for Your Project
Based on your project structure, you might want to exclude:

```properties
# Development/testing folders
**/BoostedDashB4Merge/**,\
**/BoostedDashB4Merge_old/**,\
**/PowerTune-masterold/**,\

# Backup and archive folders
**/pibackup/**,\
**/VMFiles/**,\

# Third-party or generated content
**/serwebproxy-*/**,\
**/GhostDash.apk_Decompiler.com/**
```

## Verification
To verify exclusions are working:
1. Run SonarQube analysis
2. Check the analysis logs for "Excluded sources" messages
3. Verify excluded folders don't appear in the SonarQube dashboard

## Alternative Methods

### Using .sonarignore file
Create a `.sonarignore` file in your project root:
```
BoostedDash/
PowerTune-master/
pibackup/
```

### Command-line exclusions
```bash
sonar-scanner -Dsonar.exclusions="**/folder_to_exclude/**"
```