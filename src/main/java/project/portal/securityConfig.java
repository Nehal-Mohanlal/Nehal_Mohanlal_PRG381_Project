

//////////////////////////// This was used to Configure Security namely Spring Security edietd out because it was giving errors //////////////


/* package project.portal;

//import javax.annotation.security.PermitAll;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableWebSecurity
public class securityConfig  {
    
    //@Override
    protected void configure(HttpSecurity http ) throws Exception{
        http
            .authorizeRequests()
            .anyRequest().authenticated() 
            .and()
            .formLogin().loginPage("/stulogin")
            .permitAll(); 

    }
}
 */