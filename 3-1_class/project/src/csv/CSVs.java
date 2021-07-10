package csv;

import java.io.*;
import java.nio.Buffer;
import java.util.Collections;

public class CSVs {
    /**
     * @param isFirstLineHeader csv 파일의 첫 라인을 헤더(타이틀)로 처리할까요?
     */
    public static Table createTable(File csv, boolean isFirstLineHeader) throws IOException {
        TableImple new_Table = new TableImple();
        BufferedReader br = new BufferedReader(new FileReader(csv));
        String line = "";
        String new_line ="";
        int counter = 0;

        while((line=br.readLine()) != null){
            String[] parsed;

            new_line = new_Table.change_String(line);
            parsed = new_line.split(",",-1);

            if(isFirstLineHeader == true && counter ==0){
                for(int i=0; i<parsed.length; i++) {
                    ColumnImple c = new ColumnImple();
                    c.Header = new String(parsed[i]);
                    new_Table.Columns.add(c);
                }
                new_Table.Head_line = true;
                counter++;
                continue;
            }

            for(int i=0; i<parsed.length; i++){
                parsed[i].replace('|', ',');
            }

            for(int i=0; i<parsed.length; i++) {
                if (parsed[i].equals("")) {
                    new_Table.Columns.get(i).Data.add(null);
                } else {
                    new_Table.Columns.get(i).Data.add(parsed[i]);
                }
            }
            counter++;
        }

        return new_Table;
    }

    /**
     * @return 새로운 Table 객체를 반환한다. 즉, 첫 번째 매개변수 Table은 변경되지 않는다.
     */
    public static Table sort(Table table, int byIndexOfColumn, boolean isAscending, boolean isNullFirst) {
        TableImple new_Table = new TableImple();
        TableImple origin = (TableImple) table;

        new_Table.Head_line = origin.Head_line;

        for(int i=0; i<origin.Columns.size(); i++){
            ColumnImple c = new ColumnImple();
            c.Header = new String(origin.Columns.get(i).getHeader());
            for(int j=0; j<origin.Columns.get(i).count(); j++){
                c.Data.add(origin.Columns.get(i).getValue(j));
            }
            new_Table.Columns.add(c);
        }

        new_Table.sort(byIndexOfColumn, isAscending, isNullFirst);

        return new_Table;

    }

    /**
     * @return 새로운 Table 객체를 반환한다. 즉, 첫 번째 매개변수 Table은 변경되지 않는다.
     */
    public static Table shuffle(Table table) {
        TableImple new_Table = new TableImple();
        TableImple origin = (TableImple) table;

        new_Table.Head_line = origin.Head_line;

        for(int i=0; i<origin.Columns.size(); i++){
            ColumnImple c = new ColumnImple();
            c.Header = new String(origin.Columns.get(i).getHeader());
            for(int j=0; j<origin.Columns.get(i).count(); j++){
                c.Data.add(origin.Columns.get(i).getValue(j));
            }
            new_Table.Columns.add(c);
        }

        new_Table.shuffle();

        return new_Table;
    }
}
