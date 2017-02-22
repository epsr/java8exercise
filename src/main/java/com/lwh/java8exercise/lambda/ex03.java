package com.lwh.java8exercise.lambda;

import java.io.File;
import java.io.FilenameFilter;

public class ex03 {

	public static String[] getFilesByExtentionLegacy(String path, String ext) {
		File file = new File(path);
		String[] list = file.list(new FilenameFilter() {

			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith(ext);
			}

		});

		return list;
	}

	public static String[] getFilesByExtentionLambda(String path, String ext) {
		File file = new File(path);
		return file.list((f, s) -> s.endsWith(ext));
	}

	public static void main(String[] args) {
		String path = "/home/lwh/Downloads";
		String ext = "pdf";

		String[] filesByExtentionLegacy = getFilesByExtentionLegacy(path, ext);
		String[] filesByExtentionLambda = getFilesByExtentionLambda(path, ext);

		for (String s : filesByExtentionLambda) {
			System.out.println(s);
		}
	}

}
