package milletshop.millet.entity;

/**
 * 模糊查询时传递到后台的实体类
 */
public class FuzzySearch {

    private String phoneName;
    private int minId;
    private int maxId;

    public String getPhoneName() {
        return phoneName;
    }

    public void setPhoneName(String phoneName) {
        this.phoneName = phoneName;
    }

    public int getMinId() {
        return minId;
    }

    public void setMinId(int minId) {
        this.minId = minId;
    }

    public int getMaxId() {
        return maxId;
    }

    public void setMaxId(int maxId) {
        this.maxId = maxId;
    }

    @Override
    public String toString() {
        return "FuzzySearch{" +
                "phoneName='" + phoneName + '\'' +
                ", minId=" + minId +
                ", maxId=" + maxId +
                '}';
    }
}
