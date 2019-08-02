package milletshop.millet.mvcconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * 配置跨域请求
 */
@Configuration
public class CorsConfig {
    private CorsConfiguration buildCross(){
        CorsConfiguration crossConfiguration = new CorsConfiguration();
        crossConfiguration.addAllowedOrigin("*");// 允许任何域名使用
        crossConfiguration.addAllowedHeader("*");// 允许任何头
        crossConfiguration.addAllowedMethod("*");// 允许任何方法（post、get等）
        return crossConfiguration;
    }

    @Bean
    public CorsFilter crosFilter(){
        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**",buildCross());
        return new CorsFilter(urlBasedCorsConfigurationSource);
    }
}
