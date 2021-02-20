package com.yang.config;

import org.springframework.context.annotation.Configuration;

/**
 * @Author: yang
 * @Date: 2020/12/14 下午3:16
 * @Description: 支付包支付配置
 */
@Configuration
public class AlipayConfig {

    public static String app_id = "2016102200741273";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEwAIBADANBgkqhkiG9w0BAQEFAASCBKowggSmAgEAAoIBAQCVExLcvJmUd0LMfD8yhWlEoa5zJBslDESIZtmudpBPEI/pJDWgYewIszogx1jpJ5bdFrU3AIQQqMh2QkiX5ppLK9tupyUgLyDdT0LR0f3+2qKDD/uifLj+9kK79riPeTirTaxDAQuMSGFlpUwBcRFfex/SOiN0AfjWQxyEnIrPH+XZ4/kjU4A+sGfQEhivdjjlRbHvdabRh6VPs6oX57SaYFDEXNbdKUzdigFEcxs4GR56MZIR0EQuT5f8pcUEOZa47TkXjyANTVDju5wZVIHb08YZk96ltdwDrISya7JPmQj1cYdbMBZ++LU7/ICWdbsXrneWmefZqzZBQu3s78dvAgMBAAECggEBAIyvgHiTALmNR5wlkZrDLxJXJ4SASaHQDwlPTxYHzK7hKX9T7cwbPZ8ETdJLb4wyEX07BfAPa5MxRmXcrhe0yF4y2JZ35WCXOYPCXoQXkoYmnYHk3ox8+jWcAGTVNV4pf6Ki3fQqE1Tjpg9ATRd7NnMOhnxm47iCd+z1Tv+ToKhQuA3L3reXIqUkNWAS9IfurPRxfwtOuw+aZ3xEtp4svSMb9GKgVy1QfRzkPqt8pMH2f6EkAWAYUvZbEGZzME8cZJR3VReGTrKkOqnY+Tkk/TZQKYtA7tw9uUXA+QsRPk19et0DhkJh/VtyF9VUn6Ixq90BrLUqtHPikH3J8evV2GkCgYEAzBJhFcbz2UGvy+1hg+MdPcf4hh3oav9OYISrLRROn30U7KjJuBh02OsCiQqZWCdARibwuCHEWqlXL/Fae2DZM32MZqk+ctUC8Cp7bOF3G2qE9VpvgJb55yjfu3iwapis2PcwOopewGIKRTUmNYDV5kprHyBzYS8UdOFlfrzoxhMCgYEAuwIRUBj6IZzNPYqiBo7eVMihQEdtIRKmtey4d6NHgv3wudJ7tL8V2k5amnyNF5it5BgdfR4eyDvnCAw01o2UyCPUxuVTTdaf1Bv/wTVY7jZpL7EpjJJ60S6Mu+42VqylZh5KSxCzI3PeEgWE2i2yN4qruQYHSzr7VZHfNyDc1LUCgYEAko2MbVBApMB4mFH0mvuKb2jhwKdP1y9cQRJlv+z6fa0dTsv0eaIOoA09997FuzoM/ZRPgVy2n4lHVOXWXg5yTXkXUE6wy1TQVFud4daVa/n2XCFDPCywcWK4MfD9eMAGOZZja1cdrrl5uLPvqbLJaiX9ghAS7DMcVMfd1MOjw0MCgYEAoNjxbTReiGSm/4TrQbrGrqP2ViRZT/YL4DRgob6V9qxWzm2lK1yj/iYgtfnlHWOcRbEcRA6RKWakm35sQBJ84vw2unBrC2tMA5OlklhBSnsQVA4Mj7U54AwqzkXhBQHwLXpmKlSN0DOL0XJfx41AWZdzhmwR//oWTY5vMKqaZnUCgYEAgxGRdzAuUeFb4wLagq1HZrOwDMTBrMmVqK5isgQ2UZ9xJEpfaLWws9Rmq7nT9C2Sz6JKi1+jSTPoulq9+lyunNlU5gqvY+a4ArWWdr/a84s+ql4PlQwWwTIOr3aaPYNa5AhZ4VJZFKOH8nqzpyFxVe5smM6x0nGEHbnjOaTqKFg=";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAsPzHWfLVWvKr3aAVXtlp2Cpm3QF9Oh+dM7hpFe+XWJviPw8HZOGKTX/DzYUs9ZGc4rfjeAVHT/UIH2ZpF3LZp3DXi4VqFHcGO29cRaYCMfghZHwSBpRaEmkAMgi+eVQmDe/yf0Tj2pe3H/Sjc8QEtyus6EfAbD4RNgH00WEIGbITlxywtuGIrvL668SiP8N/pSeMQ7PyT8lwZVtnsXwnSyfZSmlTg62l+dgb9LE40a/8X1fHl4QPvk8Elpq2XYm6WO+XbSpfAdJVDst489HkEvEnxdeqn/BCfYG/YVy0GLbRiQit6yq3biJkdn60T6gAnxCve95PFBimf5LBPdd89QIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://localhost:8090/haha";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://localhost:8090/static/ok.html";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 数据格式
    public static  String format = "json";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝日志
    public static String log_path = "C:\\";
}
