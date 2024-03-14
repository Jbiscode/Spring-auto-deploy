package hello.deployproject;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = "hello.deployproject", excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
// AppConfig를 제외해야 AutoAppConfig에서 ComponentScan이 정상적으로 작동하는지 확인  할 수 있어서 excludeFilters를 사용함
// 평소에는 잘 사용하지 않지만 예제코드를 최대한 유지하기 위해 사용함
public class AutoAppConfig {
}
