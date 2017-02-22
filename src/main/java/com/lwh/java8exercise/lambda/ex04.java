package com.lwh.java8exercise.lambda;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

public class ex04 {
	
	public static File[] sort(File[] files){
		return files;
		
	}
	public static void main(String[] args) {
		String path="/home/lwh";
		File[] files = new File(path).listFiles();
		
//		legacy
//
//		Arrays.sort(files, new Comparator<File>() {
//
//			@Override
//			public int compare(File o1, File o2) {
//				if (o1.isDirectory() && !o2.isDirectory()) {
//					return -1;
//				} else if (!o1.isDirectory() && o2.isDirectory()) {
//					return 1;
//				}
//				return o1.getAbsolutePath().compareTo(o2.getAbsolutePath());
//			}
//		});

		Arrays.sort(files, (o1, o2) -> {
			if (o1.isDirectory() && !o2.isDirectory()) {
				return -1;
			} else if (!o1.isDirectory() && o2.isDirectory()) {
				return 1;
			}
			return o1.getAbsolutePath().compareTo(o2.getAbsolutePath());
		});
		
		for(File f:files){
			System.out.println(f.toString());
		}
	}

}
