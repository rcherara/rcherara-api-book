package ca.rcherara.api.book.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

/**
 * @author rcherara
 *
 */
@RestController
public class VersionController {

    @GetMapping("/version")
    @ApiOperation("API Version.")
    public String getVersion() {
        return "1.0";
    }
}
