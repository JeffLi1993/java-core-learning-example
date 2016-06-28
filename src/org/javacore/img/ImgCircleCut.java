package org.javacore.img;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
/*
 * Copyright [2015] [Jeff Lee]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * @author Jeff Lee
 * @since 2016-06-28 14:05:26
 * 图片裁成椭圆
 */
public class ImgCircleCut {

    public static boolean ImgCircleCut(String srcFile, String targetFile) {
        try {
            // 获取img的BufferedImage对象,可以考虑创建不带透明色的BufferedImage对象:BufferedImage.TYPE_INT_ARGB
            BufferedImage srcBi = ImageIO.read(new File(srcFile));
            // 创建一个带透明色的BufferedImage对象
            BufferedImage targetBi = new BufferedImage(srcBi.getWidth(), srcBi.getHeight(),
                    BufferedImage.TYPE_INT_ARGB);
            // 获取img窗体矩形定义的椭圆
            Ellipse2D.Double shape = new Ellipse2D.Double(0, 0,
                    srcBi.getWidth(), srcBi.getHeight());
            // 创建目标图的Graphics2D对象
            Graphics2D g2 = targetBi.createGraphics();
            // 创建不透明 SRC_OVER 规则的 AlphaComposite 对象
            AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.9f);
            g2.setComposite(ac);
            g2.setBackground(new Color(22, 2, 2, 0));
            // 是圆形 还是 椭圆 自定义参数
            g2.fill3DRect(200, 200, 180, 80, false);
            g2.setClip(shape);
            g2.drawImage(srcBi, 0, 0, null);
            g2.dispose();
            ImageIO.write(targetBi, "png", new File(targetFile));
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
