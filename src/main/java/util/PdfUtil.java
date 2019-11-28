package util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

public class PdfUtil {

	/**
	 * ת��ȫ����pdf ���ת���ɹ������ͼƬ��ַ  ���ʧ�������null
	 * 
	 * @param fileAddress �ļ���ַ
	 * @param filename    PDF�ļ���
	 * @param type        ͼƬ����
	 */
	public static String pdf2png(String pdfPath, String imgPath, String type) {
		// ��pdfװͼƬ �����Զ���ͼƬ�ø�ʽ��С
		File file = new File(pdfPath);
		try {
			PDDocument doc = PDDocument.load(file);
			PDFRenderer renderer = new PDFRenderer(doc);
			int pageCount = doc.getNumberOfPages();
			for (int i = 0; i < pageCount; i++) {
				BufferedImage image = renderer.renderImageWithDPI(i, 144); // Windows native DPI
				// BufferedImage srcImage = resize(image, 240, 240);//��������ͼ
				ImageIO.write(image, type, new File(imgPath));
				
				// test
				File testF = new File(imgPath);
				if(testF.isFile()) {
					return imgPath;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	
}
