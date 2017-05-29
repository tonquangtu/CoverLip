package uploadserver.repositories;

import com.clteam.dataobject.*;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Dell on 22-May-17.
 */
@Repository
@Transactional
public class UploadRepository {

    @Autowired
    SessionFactory sessionFactory;

    public int insertVideo(VideoInfoEntity videoEntity) {

        if (videoEntity == null) {
            return -1;
        }
        Session session = sessionFactory.getCurrentSession();
        return (Integer)session.save(videoEntity);
    }

    public int insertCover(CoverInfoEntity coverEntity) {
        if (coverEntity == null) {
            return -1;
        }
        Session session = sessionFactory.getCurrentSession();
        return (Integer)session.save(coverEntity);
    }

    public int insertTempNewCover(TempNewCoverAdminEntity tempEntity) {

        if (tempEntity == null) {
            return -1;
        }

        Session session = sessionFactory.getCurrentSession();
        return (Integer) session.save(tempEntity);
    }

    public int insertTempNewLS(TempNewLipSyncAdminEntity tempEntity) {

        if (tempEntity == null) {
            return -1;
        }

        Session session = sessionFactory.getCurrentSession();
        return (Integer) session.save(tempEntity);
    }

    public int insertLipSync(LipSyncInfoEntity lipSyncEntity) {
        if (lipSyncEntity == null) {
            return -1;
        }
        Session session = sessionFactory.getCurrentSession();
        return (Integer)session.save(lipSyncEntity);
    }

    public void updateUser(UserInfoEntity userEntity) {

        if (userEntity == null) {
            return;
        }
        Session session = sessionFactory.getCurrentSession();
        session.update(userEntity);
    }

    public AccountEntity getAccountEntity(int accountId) {

        Session session = sessionFactory.getCurrentSession();
        return (AccountEntity) session.load(AccountEntity.class, new Integer(accountId));
    }

    public UserInfoEntity getUserEntity(int accountId) {

        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(UserInfoEntity.class);
        criteria.add(Restrictions.eq("accountId", accountId));
        List<UserInfoEntity> list = criteria.list();
        if (list != null && list.size() > 0) {
            return list.get(0);
        }

        return null;
    }

}
