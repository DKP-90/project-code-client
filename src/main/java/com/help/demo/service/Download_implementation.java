package com.help.demo.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.help.demo.model.Media;
import com.help.demo.model.Response;

@Service
public class Download_implementation implements Download_service {

	@Autowired
	Response res;
	@Autowired
	Media_service media_s_obj; 
	
	@Override
	public Response download(Media media) {
		
		res.setSuccess(false);
		res.setMessage("failed");

		new File("media").mkdir();
		try {
			saveImage(media.getMurl().toString(),"media/"+ String.valueOf(media.getMid())+".jpg");
			res.setSuccess(true);
			res.setMessage("downloaded");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			res.setSuccess(false);
			res.setMessage("failed");
		}
		return res;
	}
	
	public static void saveImage(String imageUrl, String destinationFile) throws IOException {
		URL url = new URL(imageUrl);
		InputStream is = url.openStream();
		OutputStream os = new FileOutputStream(destinationFile);

		byte[] b = new byte[2048];
		int length;

		while ((length = is.read(b)) != -1) {
			os.write(b, 0, length);
		}

		is.close();
		os.close();
	}

}
