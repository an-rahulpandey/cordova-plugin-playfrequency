# cordova-plugin-playfrequency (Work In Progress)

iOS Version is based on https://github.com/picciano/iOS-Tone-Generator


# Installation

    cordova plugin add https://github.com/an-rahulpandey/cordova-plugin-playfrequency.git


# Plugin Usage

#####Playing Audio

````var frequency = 16000; //frequency to play in Hz
    var sampleRate = 44100; //sample rate
    window.plugins.frequency.play(frequency, sampleRate);````


#####Stopping Audio

````window.plugins.frequency.stop();````