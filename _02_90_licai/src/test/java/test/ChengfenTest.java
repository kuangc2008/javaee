package test;

import com.service.ChengfenService;
import org.junit.Test;

public class ChengfenTest {
    ChengfenService serivce = new ChengfenService();


    @Test
    public void findSame() {
        serivce.findSame("/chengfen/300jiazhi", "/chengfen/300chengzhang");
    }
}
