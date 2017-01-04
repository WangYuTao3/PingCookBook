package com.ping.cookbook.bean;

import com.ping.cookbook.dao.DaoSession;
import de.greenrobot.dao.DaoException;

import com.ping.cookbook.dao.CookIndexDao;
import com.ping.cookbook.dao.StepDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "STEP".
 */
public class Step {

    private Long id;
    private String img;
    private String step;
    private Long IndexId;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient StepDao myDao;

    private CookIndex cookIndex;
    private Long cookIndex__resolvedKey;


    public Step() {
    }

    public Step(Long id) {
        this.id = id;
    }

    public Step(Long id, String img, String step, Long IndexId) {
        this.id = id;
        this.img = img;
        this.step = step;
        this.IndexId = IndexId;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getStepDao() : null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }

    public Long getIndexId() {
        return IndexId;
    }

    public void setIndexId(Long IndexId) {
        this.IndexId = IndexId;
    }

    /** To-one relationship, resolved on first access. */
    public CookIndex getCookIndex() {
        Long __key = this.IndexId;
        if (cookIndex__resolvedKey == null || !cookIndex__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            CookIndexDao targetDao = daoSession.getCookIndexDao();
            CookIndex cookIndexNew = targetDao.load(__key);
            synchronized (this) {
                cookIndex = cookIndexNew;
            	cookIndex__resolvedKey = __key;
            }
        }
        return cookIndex;
    }

    public void setCookIndex(CookIndex cookIndex) {
        synchronized (this) {
            this.cookIndex = cookIndex;
            IndexId = cookIndex == null ? null : cookIndex.getId();
            cookIndex__resolvedKey = IndexId;
        }
    }

    /** Convenient call for {@link AbstractDao#delete(Object)}. Entity must attached to an entity context. */
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.delete(this);
    }

    /** Convenient call for {@link AbstractDao#update(Object)}. Entity must attached to an entity context. */
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.update(this);
    }

    /** Convenient call for {@link AbstractDao#refresh(Object)}. Entity must attached to an entity context. */
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.refresh(this);
    }

}
