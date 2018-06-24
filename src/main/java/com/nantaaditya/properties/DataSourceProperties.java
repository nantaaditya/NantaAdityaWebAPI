package com.nantaaditya.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
// @formatter:off
/**
 * Author : Pramuditya Ananta Nur
 * www.nantaaditya.com
 * personal@nantaaditya.com
 **/
// @formatter:on

@Data
@Component
public class DataSourceProperties {

  @Value("${jwt.secret.key}")
  private String jwtSecretKey;
  @Value("${nanta.file.path}")
  private String filePath;
  @Value("${google.captcha.private.key}")
  private String captchaServerKey;
  @Value("${application.base.url}")
  private String baseUrl;
}
