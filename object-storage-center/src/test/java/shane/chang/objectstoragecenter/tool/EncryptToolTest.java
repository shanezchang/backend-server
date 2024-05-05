package shane.chang.objectstoragecenter.tool;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class EncryptToolTest {


    @Test
    void encrypt2md5() {
        log.info(EncryptTool.encrypt2md5("asd"));
    }

    @Test
    void encrypt2base64() {
    }
}