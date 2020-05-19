package com.xmb.workout.lifestyle.service.impl;

import com.xmb.workout.lifestyle.BookContentVO;
import com.xmb.workout.lifestyle.BookInfoVO;
import com.xmb.workout.lifestyle.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.io.*;

/**
 * @author Ben
 * @date 2020-03-02
 */
@Slf4j
@Service
public class BookServiceImpl implements BookService {

    @Override
    public Long getTotalChapter() {
        log.info("getTotalChapter...");
        return 10L;
    }

    /**
     * 查询书本信息
     * @return
     */
    @Override
    public BookInfoVO getBookInfo() {
        BookInfoVO bookInfoVO = new BookInfoVO();
        bookInfoVO.setChapterTotal(156L);
        bookInfoVO.setName("那人那村那傻子");
        bookInfoVO.setAuthor("福宝");
        return bookInfoVO;
    }

    @Override
    public BookContentVO getContent(int chapterNum) {

        String content = readFileContent("/root/files/book/" + chapterNum + ".txt");
        log.info("chapterNum = " + chapterNum + ", content = " + content.substring(0, 10));
        BookContentVO vo = new BookContentVO();
        vo.setContent(content);
        vo.setTitle("title");
        return vo;
    }

    public static String readFileContent(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        StringBuffer sbf = new StringBuffer();
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempStr;
            while ((tempStr = reader.readLine()) != null) {
                sbf.append(tempStr).append("\n");
            }
            reader.close();
            return sbf.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return sbf.toString();
    }

    public static void main(String[] args) {
        createChapterFiles("/Users/xian/Downloads/jkl.txt");
    }

    public static String createChapterFiles(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        StringBuffer sbf = new StringBuffer();
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempStr;
            Integer chapterNum = 743;

            while ((tempStr = reader.readLine()) != null) {
                String nextChaptername = "第" + (chapterNum + 1) + "章";
                if (tempStr.contains(nextChaptername)) {

                    writeToFile(sbf.toString(), chapterNum + "");

                    sbf = new StringBuffer();
                    chapterNum++;
                } else {
                    sbf.append(tempStr).append("\n");
//                    System.out.println("tempStr = " + tempStr);
                }
            }

            reader.close();
            return sbf.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return sbf.toString();
    }

    public static void writeToFile(String content, String fileName) {
        try {

            File file = new File("/Users/xian/Downloads/book/" + fileName + ".txt");

            // if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();

                FileWriter fw = new FileWriter(file.getAbsoluteFile());
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(content);
                bw.close();

                System.out.println("写完" + fileName + ".txt");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
