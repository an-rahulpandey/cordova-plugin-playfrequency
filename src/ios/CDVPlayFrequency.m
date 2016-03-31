/********* CDVPlayFrequency.m Cordova Plugin Implementation *******/
//
//  CDVPlayFrequency.h
//  Play Audio Frequency
//
//  Created by Rahul Pandey on 30/03/16.
//
//

#import "CDVPlayFrequency.h"

@implementation CDVPlayFrequency
@synthesize toneGenRef;

-(void)pluginInitialize {
    NSLog(@"initialize");
    toneGenRef =  [[TGSineWaveToneGenerator alloc] initWithChannels:2];
}

- (void)playfrequency:(CDVInvokedUrlCommand*)command {
    //CDVPluginResult* pluginResult = nil;
    double freq = [[command.arguments objectAtIndex:0] doubleValue];
    NSLog(@"Frequency = %f",freq);
    toneGenRef->_channels[0].frequency=freq;
    toneGenRef->_sampleRate = [[command.arguments objectAtIndex:1] doubleValue];
    [toneGenRef play];
}


- (void)stopfrequency:(CDVInvokedUrlCommand*)command {
    [toneGenRef stop];
}
@end
