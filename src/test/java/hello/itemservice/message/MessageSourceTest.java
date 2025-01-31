package hello.itemservice.message;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;

import java.util.Locale;

import static org.assertj.core.api.Assertions.*;

/**
 * packageName    : hello.itemservice.message
 * fileName       : MessageSourceTest
 * author         : Sora
 * date           : 2024-07-11
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-07-11        Sora       최초 생성
 */
@SpringBootTest
public class MessageSourceTest {

    @Autowired
    MessageSource ms;

    @Test
    void helloMessage(){
        String result = ms.getMessage("hello", null, null);

        assertThat(result).isEqualTo("안녕");

    }

    @Test
    void notFoundMessageCode(){
        assertThatThrownBy(() -> ms.getMessage("no_code", null, null))
                .isInstanceOf(NoSuchMessageException.class);
    }

    @Test
    void notFoundMessageCodeDefaultMessage(){
        String result = ms.getMessage("no_code", null, "기본 메시지", null);
        assertThat(result).isEqualTo("기본 메시지");
    }

    @Test
    void argumentMessage(){
        String message = ms.getMessage("hello.name",new Object[]{"Spring"}, null);
        assertThat(message).isEqualTo("안녕 Spring");
    }


    @Test
    void defaultLang(){
        assertThat(ms.getMessage("hello", null ,null)).isEqualTo("안녕");
        // KOREA는 없기때문에 default properties가 출력
        assertThat(ms.getMessage("hello", null , Locale.KOREA)).isEqualTo("안녕");
    }

    @Test
    void enLang(){
        assertThat(ms.getMessage("hello", null, Locale.ENGLISH)).isEqualTo("hello");
        assertThat(ms.getMessage("hello.name", new Object[]{"Spring!"},Locale.ENGLISH)).isEqualTo("hello Spring!");
    }

}
