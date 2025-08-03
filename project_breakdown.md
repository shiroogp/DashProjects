# Dash Repository Project Breakdown

This document provides a comprehensive breakdown of the various projects in the Dash repository, explaining their purpose, functionality, and relationships.

## Main Dashboard Projects

### 1. Ghost Dashboard Skins SDK (skins/)
- **Purpose**: A platform for creating custom automotive dashboard skins using web technologies
- **Technology**: HTML, CSS, JavaScript
- **Features**:
  - Custom skin creation with web technologies
  - Real-time data visualization
  - Customizable UI elements
  - Performance optimized for embedded hardware
- **Hardware Target**: Embedded ARM processor (1.44GHz quad-core, 512MB RAM)
- **Notes**: Designed for creating lightweight, customizable dashboard interfaces that can be deployed to dedicated dashboard hardware

### 2. BoostedDash / PowerTune (BoostedDash/, PowerTune-master/)
- **Purpose**: Qt-based automotive dashboard display for various ECUs
- **Technology**: Qt/C++, QML
- **Features**:
  - Support for multiple ECU types (Apexi Power FC, Adaptronic, Haltech, Microtech, etc.)
  - Real-time data visualization
  - GPS integration
  - Data logging to CSV
  - GoPro remote control
  - Customizable gauges and displays
- **Hardware Target**: Raspberry Pi, Linux, Windows
- **Notes**: BoostedDash appears to be a rebranded version of PowerTune with similar functionality

### 3. GhostDash (GhostDash/)
- **Purpose**: Android application for automotive dashboard display
- **Technology**: Android/Kotlin
- **Features**: 
  - Mobile dashboard interface
  - Likely connects to vehicle data via Bluetooth or WiFi
- **Hardware Target**: Android devices
- **Notes**: Appears to be the mobile companion to the Ghost Dashboard system

### 4. JHUD (JHUD/)
- **Purpose**: Python-based heads-up display
- **Technology**: Python
- **Features**:
  - OBD-II communication
  - IMU (Inertial Measurement Unit) integration
  - Websocket client functionality
- **Hardware Target**: Likely Raspberry Pi
- **Notes**: Focused on providing a heads-up display interface with various data inputs

### 5. pyracedash (pyracedash/)
- **Purpose**: Python-based dashboard for Project CARS racing simulator
- **Technology**: Python, Pygame
- **Features**:
  - Connects to Project CARS via CREST API
  - Customizable themes
  - Displays racing telemetry data
- **Hardware Target**: Raspberry Pi with LCD display, also works on standard computers
- **Notes**: Unlike other projects, this is for simulation rather than real vehicle data

### 6. d3-car-dashboard (d3-car-dashboard/)
- **Purpose**: Web-based dashboard using Angular
- **Technology**: Angular, TypeScript
- **Features**: 
  - Modern web-based interface
  - Likely connects to vehicle data via websockets
- **Hardware Target**: Web browsers
- **Notes**: Represents a more modern web approach compared to the Ghost Dashboard Skins

## Supporting Projects and Tools

### 1. mypis (mypis/)
- **Purpose**: Raspberry Pi configurations for dashboard displays
- **Technology**: Python, HTML
- **Components**:
  - bigtouchscreen: Configuration for large touchscreen displays
  - smalltouchwithmq: Configuration for small touchscreen displays
  - serial_websocket: Communication bridge between serial data and web clients
  - html: Web interface components

### 2. pyobd-pi (pyobd-pi/)
- **Purpose**: Python-based OBD-II diagnostic tool
- **Technology**: Python
- **Features**:
  - OBD communication
  - Data capture and recording
  - Diagnostic interface
- **Hardware Target**: Raspberry Pi
- **Notes**: More focused on diagnostics than dashboard display

### 3. serial_websocket (mypis/serial_websocket/)
- **Purpose**: Bridge between serial vehicle data and web clients
- **Technology**: Python, WebSockets
- **Features**:
  - Reads data from serial ports
  - Broadcasts data via WebSockets
  - Enables web-based dashboards to receive vehicle data
- **Notes**: Critical component for web-based dashboard implementations

### 4. VMFiles (VMFiles/)
- **Purpose**: Development workspace containing multiple versions of dashboard projects
- **Contents**: Various versions of BoostedDash, PowerTune, and related tools
- **Notes**: Appears to be a workspace for active development across multiple related projects

## Development and Utility Scripts

### 1. startBoostedDash.sh
- **Purpose**: Launcher script for BoostedDash on Raspberry Pi
- **Features**: Sets display dimensions and launches the application
- **Notes**: Confirms the system is designed to run on embedded Linux devices

### 2. Various Python Scripts (*.py)
- **Purpose**: Various utility scripts for dashboard functionality
- **Examples**:
  - dashKi.py: Likely a dashboard implementation
  - connector.py: Probably handles connections to vehicle data
  - abroadcastlisten.py: Appears to listen for broadcast data
- **Notes**: These scripts provide supporting functionality for the main dashboard projects

## Relationships Between Projects

The repository contains multiple approaches to creating automotive dashboards:

1. **Native Applications**: BoostedDash/PowerTune represent a Qt-based approach for dedicated hardware
2. **Web-Based Interfaces**: Ghost Dashboard Skins and d3-car-dashboard represent web technology approaches
3. **Python Implementations**: JHUD, pyobd-pi, and pyracedash represent Python-based approaches
4. **Mobile Applications**: GhostDash represents an Android-based approach

The projects share common goals but use different technology stacks, likely targeting different use cases and hardware configurations. The serial_websocket component appears to be a bridge that enables communication between vehicle data sources and web-based dashboards.

Many of the projects appear to be variations or evolutions of each other, suggesting active development and experimentation with different approaches to automotive dashboard displays.