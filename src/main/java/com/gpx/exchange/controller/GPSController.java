package com.gpx.exchange.controller;

import com.gpx.exchange.constant.status.AppStatus;
import com.gpx.exchange.service.IGPSService;
import com.gpx.exchange.utils.RequestUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/gps")
public class GPSController {

    private final IGPSService gpsService;

    public GPSController(IGPSService gpsService) {
        this.gpsService = gpsService;
    }

    @GetMapping(path = "/track/latest")
    public ResponseEntity<Object> getLatestTrack(@RequestParam(value = "pageNumber", defaultValue = "1") int pageNumber,
                                                 @RequestParam(value = "pageSize", defaultValue = "20") int pageSize) {
        AppStatus appStatus = gpsService.getLatestTrack(pageNumber, pageSize);
        return RequestUtils.getResponse(appStatus);
    }

    @PostMapping(path = "/upload")
    public ResponseEntity<Object> uploadFile(@RequestPart("file") MultipartFile file) {
        return RequestUtils.getResponse(gpsService.uploadFile(file));
    }

    @GetMapping(path = "/detail/{id}")
    public ResponseEntity<Object> getTrackDetailByGPSId(@PathVariable("id") Long id) {
        return RequestUtils.getResponse(gpsService.getGPXDetailByGPSId(id));
    }
}
