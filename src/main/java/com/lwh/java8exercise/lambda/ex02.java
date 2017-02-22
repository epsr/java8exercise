package com.lwh.java8exercise.lambda;

import java.io.File;
import java.io.FileFilter;

public class ex02 {

	public static File[] getChildDirectoryLegacy(String path) {
		File file = new File(path);
		File[] listFiles = file.listFiles(new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				return pathname.isDirectory();
			}
		});
		return listFiles;
	}

	public static File[] getChildDirectoryLambda(String path) {
		File file = new File(path);
		return file.listFiles(f -> f.isDirectory());
	}

	public static File[] getChildDirectoryMethodReference(String path) {
		File file = new File(path);
		return file.listFiles(File::isDirectory);
	}

	public static void main(String[] args) {

		String path = "/home/lwh";

		File[] legacy = getChildDirectoryLegacy(path);
		File[] lambda = getChildDirectoryLambda(path);
		File[] method = getChildDirectoryMethodReference(path);

		for (File f : method) {
			System.out.println(f.toString());
		}
	}

}
