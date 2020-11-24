package cn.ykf;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 主程序
 *
 * @author YuKaiFan<yukf @ pvc123.com>
 * @date 2020-11-22
 */
public class MainApplication {

    public static void main(String[] args) throws Exception {
        // 启动容器
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("provider.xml");
        context.start();

        // 任意键退出
        System.in.read();
    }
}
