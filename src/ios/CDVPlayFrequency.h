//
//  CDVPlayFrequency.h
//  Play Audio Frequency
//
//  Created by Rahul Pandey on 30/03/16.
//
//

#import <Cordova/CDVPlugin.h>
#import "TGSineWaveToneGenerator.h"

@class TGSineWaveToneGenerator;

@interface CDVPlayFrequency : CDVPlugin {
    // Member variables go here.
    TGSineWaveToneGenerator *toneGenRef;
}

@property(strong) TGSineWaveToneGenerator *toneGenRef;

- (void)playfrequency:(CDVInvokedUrlCommand*)command;
- (void)stopfrequency:(CDVInvokedUrlCommand*)command;
@end
