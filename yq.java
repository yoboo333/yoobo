package study;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class yq {

    public static void main(String[] args) throws IOException {

        String fileName ="E:\\1\\yq_in.txt";
        String fileName2 ="E:\\1\\yq_out.txt";
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "gbk"));
        String line =bufferedReader.readLine();
        //设置动态数组存放内容
        List<String[]> l1=new ArrayList<>();
        while (line!=null){
            l1.add(line.split("	"));
            line = bufferedReader.readLine();
        }
        bufferedReader.close();
        //写入到out文件
        BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName2), "gbk"));
        //设置一个标记字符串
        String mark ="xxx";
        for(int i=0;i<l1.size();i++){
            if (!mark.equals(l1.get(i)[0])){
                if (!mark.equals("xxx"))
                {
                    writer.write("\n");
                    writer.write(l1.get(i)[0]+"\n");
                }
                else{
                    writer.write(l1.get(i)[0]+"\n");
                }
                mark = l1.get(i)[0];
            }
            if (!l1.get(i)[1].equals("待明确地区"))
                writer.write(l1.get(i)[1]+"	"+l1.get(i)[2]+"\n");
        }
        writer.close();
    }
}
