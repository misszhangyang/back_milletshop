package milletshop.millet.dao;

import milletshop.millet.mapper.PurchaseRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PurchaseRecord {

    @Autowired
    private PurchaseRecordMapper purchaseRecordMapper;

    public int insertPruchaseRecord(PurchaseRecord purchaseRecord){
       return purchaseRecord.insertPruchaseRecord(purchaseRecord);
    }


}
