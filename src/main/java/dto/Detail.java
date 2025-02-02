package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Detail {
    private Integer id;
    private String plantCpl;
    private String plantName;
    private String japaneseName;
    private String scientificName;
    private String genusName;
    private String description;
    private String imagePath;
    

    // 簡易的なコンストラクター
    // 必要に応じてデフォルトコンストラクタを追加
    public Detail(int id, String plantName, String description, String plantCpl,String japaneseName, String scientificName, String genusName, String imagePath) {
        this.plantCpl = plantCpl;
        this.plantName = plantName;
        this.japaneseName = japaneseName;
        this.scientificName = scientificName;
        this.genusName = genusName;
        this.description = description;
        this.imagePath = imagePath;
    }

}
