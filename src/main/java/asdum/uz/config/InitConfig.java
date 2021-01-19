package asdum.uz.config;

import org.springframework.core.io.ClassPathResource;

import javax.swing.*;
import java.util.Properties;

public class InitConfig {

    public static boolean isStart(){
        Properties props = new Properties();
        try {
            props.load(new ClassPathResource("/application.properties").getInputStream());
            if (props.getProperty("spring.jpa.hibernate.ddl-auto").equals("update")){
                return true;
            }else{
                String confirm = JOptionPane.showInputDialog("Be careful, the database will open. Delete code (1234) :");
                if (confirm!=null && confirm.equals("1234")){
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
