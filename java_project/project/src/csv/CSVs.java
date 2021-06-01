package csv;

import javax.management.monitor.StringMonitor;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


public class CSVs {

    /**
     * @param isFirstLineHeader csv 파일의 첫 라인을 헤더(타이틀)로 처리할까요?
     */

    public static Table createTable(File csv, boolean isFirstLineHeader) throws FileNotFoundException {

        TableImpl ta = new TableImpl();

        BufferedReader br = null;

        ColumnImpl col = new ColumnImpl();



        if (isFirstLineHeader) {
            ta.isheader_on = true;
        } else ta.isheader_on = false;

        int header_count = 0;


        try {
            br = Files.newBufferedReader(Paths.get(csv.getPath()));

            String line = "";


            while ((line = br.readLine()) != null) {
                //CSV 1행을 저장하는 리스트
                List<String> tmpList = new ArrayList<String>();

                int index_fr = line.indexOf('"');
                int index_end = line.lastIndexOf('"');

                if (isFirstLineHeader == true && header_count == 0) {


                    String array[] = line.split("\\,");
                    header_count = 1;


                    tmpList = Arrays.asList(array);


                    for (int i = 0; i < array.length; i++) {
                        ta.Head.header.add(array[i]);
                    }

                } else {

                }

                try {

                    String tmp = line.substring((int) line.indexOf('"'), (int) line.lastIndexOf('"'));
                    tmp = tmp.replace(',', '|');

                    line = line.substring(0, line.indexOf('"')) + tmp.substring(1,tmp.length())
                            + line.substring(line.lastIndexOf('"') + 1);


                    String array[] = line.split(",", -1);



                    for (int i = 0; i < array.length; i++) {
                        array[i] = array[i].replace('|', ',');
                        array[i] = array[i].replace("\"\"", "\"");

                    }



                    for (int i = 0; i < array.length; i++) {

                        if(array[i] ==""){
                            array[i]=null;
                        }
                    }


                    //배열에서 리스트 반환
                    tmpList = Arrays.asList(array);
                    ta.temp_data.add(tmpList);

                }
                catch(StringIndexOutOfBoundsException a){


                }
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        for (int i = 0; i < ta.temp_data.get(0).size(); i++) {
            ColumnImpl c = new ColumnImpl();


            for (int j = 0; j < ta.temp_data.size(); j++) {
                c.datas.add(ta.temp_data.get(j).get(i));

            }

            System.out.println(c.datas);

            c.Data_Type = c.check_type(c);
            c.check_non_null_cnt(c);
            ta.col_zip.add(c);
        }






        return ta;


    }

    /**
     * @return 새로운 Table 객체를 반환한다. 즉, 첫 번째 매개변수 Table은 변경되지 않는다.
     */
    public static Table sort(Table table, int byIndexOfColumn, boolean isAscending, boolean isNullFirst) {

        //채우기


        return null;
    }

    /**
     * @return 새로운 Table 객체를 반환한다. 즉, 첫 번째 매개변수 Table은 변경되지 않는다.
     */
    public static Table shuffle(Table table) {


        TableImpl new_table = new TableImpl();
        TableImpl temp_new_table = (TableImpl) table;
        new_table.Head.header = temp_new_table.Head.header;


        ColumnImpl c = new ColumnImpl();


       Collections.shuffle(temp_new_table.temp_data);

       //해결


        for (int i = 0; i < temp_new_table.temp_data.get(0).size()/*12*/; i++) {
            ColumnImpl co = new ColumnImpl();

            for (int j = 0; j < temp_new_table.col_zip.get(i).datas.size(); j++) {
                co.datas.add(temp_new_table.temp_data.get(j).get(i));

            }

            new_table.col_zip.add(co);
        }

        //디버깅을 위한 프린트문 new_tabel안에 데이터들 ㅜㄹ력하게



        return new_table;
    }
}
