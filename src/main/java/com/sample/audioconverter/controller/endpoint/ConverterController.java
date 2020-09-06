package com.sample.audioconverter.controller.endpoint;

import com.sample.audioconverter.model.Converter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ConverterController {
    @Value("${inputFiles.path}")
    public String input;

    @Value("${convertedFiles.path}")
    public String converted;

    @Value("${ffmpeg.path}")
    public String tool;

    @RequestMapping(method = RequestMethod.POST, value = "/convertAudio")
    public String convertAudio(@RequestParam("file") final MultipartFile file, @RequestParam("format") final String format, @RequestParam("codec") final String codec, @RequestParam("bitRate") final String bitRate,
                               @RequestParam("channels") final String channels, @RequestParam("sampleRate") final String sampleRate, @RequestParam("start") final String start, @RequestParam("duration") final String duration, final String vol) {
        Converter converter = new Converter();
        return converter.convertAudio(file, format, codec, bitRate, channels, sampleRate, start, duration, vol, input, converted, tool);
    }
}
