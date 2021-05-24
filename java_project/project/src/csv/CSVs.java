package csv;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CSVs {
    /**
     * @param isFirstLineHeader csv 파일의 첫 라인을 헤더(타이틀)로 처리할까요?
     */
    public static Table createTable(File csv, boolean isFirstLineHeader) throws FileNotFoundException {
        try {
            FileReader filereader = new FileReader(csv);
            int singleCh = 0;
            while ((singleCh = filereader.read()) != -1) {
                //System.out.print((char) singleCh);
            }
            filereader.close();
        } catch (
                FileNotFoundException e) {
            // TODO: handle exception
        } catch (
                IOException e) {
            System.out.println(e);
        }





            return null;
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

        //채우기

        return null;
    }
}
