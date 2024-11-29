package hello.boot.config;

import hello.boot.datasource.MyDataSource;
import hello.boot.datasource.MyDataSourcePropertiesV2;
import hello.boot.datasource.MyDataSourcePropertiesV3;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;

@Slf4j
// @EnableConfigurationProperties(MyDataSourcePropertiesV3.class) // @ConfigurationProperties 로 정의한 것을 가져다 사용하고 싶다면 EnableConfigurationProperties 를 적어주어야 한다. ( 그러면 MyDataSourcePropertiesV3 을 다 읽어서, 외부 설정 값을 주입한 다음에 스프링 빈으로 등록해준다. )
public class MyDataSourceConfigV3 {

    private final MyDataSourcePropertiesV3 properties;

    public MyDataSourceConfigV3(MyDataSourcePropertiesV3 properties) {
        this.properties = properties;
    }

    @Bean
    public MyDataSource dataSource() {
        return new MyDataSource(
                properties.getUrl(), properties.getUsername(), properties.getPassword(),
                properties.getEtc().getMaxConnection(), properties.getEtc().getTimeout(),
                properties.getEtc().getOptions());
    }

}
