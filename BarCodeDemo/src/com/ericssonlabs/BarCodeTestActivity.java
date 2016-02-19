package com.ericssonlabs;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Hashtable;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.zxing.encoding.EncodingHandler;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * ********************************************************** 内容摘要 ：二维码生成及扫瞄
 * <p>
 * 
 * 作者 ：gy 创建时间 ：2013-6-5 上午10:56:36 当前版本号：v1.0 历史记录 : 日期 : 2013-6-5 上午10:56:36
 * 修改人： 描述 :
 *********************************************************** 
 */
public class BarCodeTestActivity extends Activity {
	private TextView resultTextView;
	private EditText qrStrEditText;
	private ImageView qrImgImageView;
	private static final int IMAGE_HALFWIDTH = 20;
	int[] pixels = new int[2 * IMAGE_HALFWIDTH * 2 * IMAGE_HALFWIDTH];
	private Bitmap mBitmap;
	private final String IMAGE_TYPE = "image/*";

	private final int IMAGE_CODE = 0; // �����IMAGE_CODE���Լ����ⶨ���
	private final int SCANER_CODE = 1;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		qrImgImageView = (ImageView) this.findViewById(R.id.iv_qr_image);

		Button generateQRCodeButton = (Button) this
				.findViewById(R.id.btn_add_qrcode);
		generateQRCodeButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				try {
					String contentString = "http://cdt.cq.189.cn:8080/adslfix/guzhangInfo.action?stbId=001002990104510013045CC6D07613D4&adslAccount=123456&errorCode=0002&info=在线升级失败"; //qrStrEditText.getText().toString();
					if (contentString != null
							&& contentString.trim().length() > 0) {
						// 根据字符串生成二维码图片并显示在界面上，第二个参数为图片的大小（350*350）
						Bitmap qrCodeBitmap = EncodingHandler.createQRCode(
								contentString, 280);
						//saveJpeg(qrCodeBitmap);
						qrImgImageView.setImageBitmap(qrCodeBitmap);
					} else {
						Toast.makeText(BarCodeTestActivity.this,
								"Text can not be empty", Toast.LENGTH_SHORT)
								.show();
					}

				} catch (WriterException e) {
					e.printStackTrace();
				}
			}
		});
	}
		
}