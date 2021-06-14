package practiceAPI.binaryimg;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.math.BigInteger;

public class PngToBinary {

    public static void main(String[] args) {
        try {
            System.out.println("superman");
            BufferedImage sourceimage = ImageIO.read(new File("C:\\Users\\Computer\\Pictures\\img_example.jpg"));
            ByteArrayOutputStream bytes = new ByteArrayOutputStream();
            ImageIO.write(sourceimage, "jpg", bytes); //data 형식대로 변경
            String resultantimage = Base64.encode(bytes.toByteArray());
            String binary = new BigInteger(resultantimage.getBytes()).toString(2);
            System.out.println(binary);
            /**
             * 하드에 저장인지 확인(imageIO.read)
             * bytes(==binary) S3에 stream을 바로 복제해서 업로드
             *
             * ###조과장님 피드백 ###
             *     1. img src(이미지 파일과 동일)를 Data URL과 유사한 API를 사용해 추출합니다.
             *     2. 추출한 텍스트로 된 이미지 파일을 binary로 변경합니다.
             *         - AWS에 업로드 할 것이기 때문에 하드에 파일을 저장해선 안되며 S3에 Stream 형식으로 바로 저장되게 합니다.
             *     3. AWS S3와 연동합니다.
             *     4. AWS S3에 binary양식으로 된 이미지 파일을 업로드하면 URL을 변환해줍니다.
             *     5. URL을 img src로 대체해준다음 DB에 저장해줍니다.
             *     6. 성능향상
             *         - 백 :
             *             - text보다 binary로 AWS S3로 업로드 하는 시간을 단축시켜줍니다.
             *             - DB 상당한 메모리를 세이브 할 수 있습니다.
             *         - 프런트 : S3 url을 읽어오기 때문에 실제 파일(48페이지 짜리 text)를 읽어오는 것보다 속도가 빠릅니다.
             * */
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
