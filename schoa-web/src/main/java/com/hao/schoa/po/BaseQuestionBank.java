package com.hao.schoa.po;


import java.math.BigDecimal;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.ObjectUtils;
import org.apache.torque.TorqueException;
import org.apache.torque.map.TableMap;
import org.apache.torque.om.BaseObject;
import org.apache.torque.om.ComboKey;
import org.apache.torque.om.DateKey;
import org.apache.torque.om.NumberKey;
import org.apache.torque.om.ObjectKey;
import org.apache.torque.om.SimpleKey;
import org.apache.torque.om.StringKey;
import org.apache.torque.om.Persistent;
import org.apache.torque.util.Criteria;
import org.apache.torque.util.Transaction;





/**
 * You should not use this class directly.  It should not even be
 * extended all references should be to QuestionBank
 */
public abstract class BaseQuestionBank extends BaseObject
{
    /** The Peer class */
    private static final QuestionBankPeer peer =
        new QuestionBankPeer();


    /** The value for the id field */
    private int id;

    /** The value for the content field */
    private String content;

    /** The value for the answer field */
    private String answer;

    /** The value for the img field */
    private String img;

    /** The value for the tixingId field */
    private int tixingId = 0;

    /** The value for the materialId field */
    private int materialId = 0;

    /** The value for the materialKechengId field */
    private int materialKechengId = 0;

    /** The value for the knowledgePointId field */
    private String knowledgePointId;

    /** The value for the wordsLevel field */
    private String wordsLevel;

    /** The value for the tags field */
    private String tags;

    /** The value for the fenci field */
    private String fenci;

    /** The value for the remark field */
    private String remark;

    /** The value for the member field */
    private String member;

    /** The value for the createTime field */
    private Date createTime;

    /** The value for the createMemberId field */
    private int createMemberId = 0;

    /** The value for the createMember field */
    private String createMember;

    /** The value for the modifyTime field */
    private Date modifyTime;

    /** The value for the modifyMemberId field */
    private int modifyMemberId = 0;

    /** The value for the modifyMember field */
    private String modifyMember;

    /** The value for the imgA field */
    private String imgA;

    /** The value for the imgB field */
    private String imgB;

    /** The value for the imgC field */
    private String imgC;

    /** The value for the imgD field */
    private String imgD;

    /** The value for the imgE field */
    private String imgE;

    /** The value for the imgF field */
    private String imgF;

    /** The value for the usedTimes field */
    private int usedTimes = 0;


    /**
     * Get the Id
     *
     * @return int
     */
    public int getId()
    {
        return id;
    }


    /**
     * Set the value of Id
     *
     * @param v new value
     */
    public void setId(int v) 
    {

        if (this.id != v)
        {
            this.id = v;
            setModified(true);
        }


    }

    /**
     * Get the Content
     *
     * @return String
     */
    public String getContent()
    {
        return content;
    }


    /**
     * Set the value of Content
     *
     * @param v new value
     */
    public void setContent(String v) 
    {

        if (!ObjectUtils.equals(this.content, v))
        {
            this.content = v;
            setModified(true);
        }


    }

    /**
     * Get the Answer
     *
     * @return String
     */
    public String getAnswer()
    {
        return answer;
    }


    /**
     * Set the value of Answer
     *
     * @param v new value
     */
    public void setAnswer(String v) 
    {

        if (!ObjectUtils.equals(this.answer, v))
        {
            this.answer = v;
            setModified(true);
        }


    }

    /**
     * Get the Img
     *
     * @return String
     */
    public String getImg()
    {
        return img;
    }


    /**
     * Set the value of Img
     *
     * @param v new value
     */
    public void setImg(String v) 
    {

        if (!ObjectUtils.equals(this.img, v))
        {
            this.img = v;
            setModified(true);
        }


    }

    /**
     * Get the TixingId
     *
     * @return int
     */
    public int getTixingId()
    {
        return tixingId;
    }


    /**
     * Set the value of TixingId
     *
     * @param v new value
     */
    public void setTixingId(int v) 
    {

        if (this.tixingId != v)
        {
            this.tixingId = v;
            setModified(true);
        }


    }

    /**
     * Get the MaterialId
     *
     * @return int
     */
    public int getMaterialId()
    {
        return materialId;
    }


    /**
     * Set the value of MaterialId
     *
     * @param v new value
     */
    public void setMaterialId(int v) 
    {

        if (this.materialId != v)
        {
            this.materialId = v;
            setModified(true);
        }


    }

    /**
     * Get the MaterialKechengId
     *
     * @return int
     */
    public int getMaterialKechengId()
    {
        return materialKechengId;
    }


    /**
     * Set the value of MaterialKechengId
     *
     * @param v new value
     */
    public void setMaterialKechengId(int v) 
    {

        if (this.materialKechengId != v)
        {
            this.materialKechengId = v;
            setModified(true);
        }


    }

    /**
     * Get the KnowledgePointId
     *
     * @return String
     */
    public String getKnowledgePointId()
    {
        return knowledgePointId;
    }


    /**
     * Set the value of KnowledgePointId
     *
     * @param v new value
     */
    public void setKnowledgePointId(String v) 
    {

        if (!ObjectUtils.equals(this.knowledgePointId, v))
        {
            this.knowledgePointId = v;
            setModified(true);
        }


    }

    /**
     * Get the WordsLevel
     *
     * @return String
     */
    public String getWordsLevel()
    {
        return wordsLevel;
    }


    /**
     * Set the value of WordsLevel
     *
     * @param v new value
     */
    public void setWordsLevel(String v) 
    {

        if (!ObjectUtils.equals(this.wordsLevel, v))
        {
            this.wordsLevel = v;
            setModified(true);
        }


    }

    /**
     * Get the Tags
     *
     * @return String
     */
    public String getTags()
    {
        return tags;
    }


    /**
     * Set the value of Tags
     *
     * @param v new value
     */
    public void setTags(String v) 
    {

        if (!ObjectUtils.equals(this.tags, v))
        {
            this.tags = v;
            setModified(true);
        }


    }

    /**
     * Get the Fenci
     *
     * @return String
     */
    public String getFenci()
    {
        return fenci;
    }


    /**
     * Set the value of Fenci
     *
     * @param v new value
     */
    public void setFenci(String v) 
    {

        if (!ObjectUtils.equals(this.fenci, v))
        {
            this.fenci = v;
            setModified(true);
        }


    }

    /**
     * Get the Remark
     *
     * @return String
     */
    public String getRemark()
    {
        return remark;
    }


    /**
     * Set the value of Remark
     *
     * @param v new value
     */
    public void setRemark(String v) 
    {

        if (!ObjectUtils.equals(this.remark, v))
        {
            this.remark = v;
            setModified(true);
        }


    }

    /**
     * Get the Member
     *
     * @return String
     */
    public String getMember()
    {
        return member;
    }


    /**
     * Set the value of Member
     *
     * @param v new value
     */
    public void setMember(String v) 
    {

        if (!ObjectUtils.equals(this.member, v))
        {
            this.member = v;
            setModified(true);
        }


    }

    /**
     * Get the CreateTime
     *
     * @return Date
     */
    public Date getCreateTime()
    {
        return createTime;
    }


    /**
     * Set the value of CreateTime
     *
     * @param v new value
     */
    public void setCreateTime(Date v) 
    {

        if (!ObjectUtils.equals(this.createTime, v))
        {
            this.createTime = v;
            setModified(true);
        }


    }

    /**
     * Get the CreateMemberId
     *
     * @return int
     */
    public int getCreateMemberId()
    {
        return createMemberId;
    }


    /**
     * Set the value of CreateMemberId
     *
     * @param v new value
     */
    public void setCreateMemberId(int v) 
    {

        if (this.createMemberId != v)
        {
            this.createMemberId = v;
            setModified(true);
        }


    }

    /**
     * Get the CreateMember
     *
     * @return String
     */
    public String getCreateMember()
    {
        return createMember;
    }


    /**
     * Set the value of CreateMember
     *
     * @param v new value
     */
    public void setCreateMember(String v) 
    {

        if (!ObjectUtils.equals(this.createMember, v))
        {
            this.createMember = v;
            setModified(true);
        }


    }

    /**
     * Get the ModifyTime
     *
     * @return Date
     */
    public Date getModifyTime()
    {
        return modifyTime;
    }


    /**
     * Set the value of ModifyTime
     *
     * @param v new value
     */
    public void setModifyTime(Date v) 
    {

        if (!ObjectUtils.equals(this.modifyTime, v))
        {
            this.modifyTime = v;
            setModified(true);
        }


    }

    /**
     * Get the ModifyMemberId
     *
     * @return int
     */
    public int getModifyMemberId()
    {
        return modifyMemberId;
    }


    /**
     * Set the value of ModifyMemberId
     *
     * @param v new value
     */
    public void setModifyMemberId(int v) 
    {

        if (this.modifyMemberId != v)
        {
            this.modifyMemberId = v;
            setModified(true);
        }


    }

    /**
     * Get the ModifyMember
     *
     * @return String
     */
    public String getModifyMember()
    {
        return modifyMember;
    }


    /**
     * Set the value of ModifyMember
     *
     * @param v new value
     */
    public void setModifyMember(String v) 
    {

        if (!ObjectUtils.equals(this.modifyMember, v))
        {
            this.modifyMember = v;
            setModified(true);
        }


    }

    /**
     * Get the ImgA
     *
     * @return String
     */
    public String getImgA()
    {
        return imgA;
    }


    /**
     * Set the value of ImgA
     *
     * @param v new value
     */
    public void setImgA(String v) 
    {

        if (!ObjectUtils.equals(this.imgA, v))
        {
            this.imgA = v;
            setModified(true);
        }


    }

    /**
     * Get the ImgB
     *
     * @return String
     */
    public String getImgB()
    {
        return imgB;
    }


    /**
     * Set the value of ImgB
     *
     * @param v new value
     */
    public void setImgB(String v) 
    {

        if (!ObjectUtils.equals(this.imgB, v))
        {
            this.imgB = v;
            setModified(true);
        }


    }

    /**
     * Get the ImgC
     *
     * @return String
     */
    public String getImgC()
    {
        return imgC;
    }


    /**
     * Set the value of ImgC
     *
     * @param v new value
     */
    public void setImgC(String v) 
    {

        if (!ObjectUtils.equals(this.imgC, v))
        {
            this.imgC = v;
            setModified(true);
        }


    }

    /**
     * Get the ImgD
     *
     * @return String
     */
    public String getImgD()
    {
        return imgD;
    }


    /**
     * Set the value of ImgD
     *
     * @param v new value
     */
    public void setImgD(String v) 
    {

        if (!ObjectUtils.equals(this.imgD, v))
        {
            this.imgD = v;
            setModified(true);
        }


    }

    /**
     * Get the ImgE
     *
     * @return String
     */
    public String getImgE()
    {
        return imgE;
    }


    /**
     * Set the value of ImgE
     *
     * @param v new value
     */
    public void setImgE(String v) 
    {

        if (!ObjectUtils.equals(this.imgE, v))
        {
            this.imgE = v;
            setModified(true);
        }


    }

    /**
     * Get the ImgF
     *
     * @return String
     */
    public String getImgF()
    {
        return imgF;
    }


    /**
     * Set the value of ImgF
     *
     * @param v new value
     */
    public void setImgF(String v) 
    {

        if (!ObjectUtils.equals(this.imgF, v))
        {
            this.imgF = v;
            setModified(true);
        }


    }

    /**
     * Get the UsedTimes
     *
     * @return int
     */
    public int getUsedTimes()
    {
        return usedTimes;
    }


    /**
     * Set the value of UsedTimes
     *
     * @param v new value
     */
    public void setUsedTimes(int v) 
    {

        if (this.usedTimes != v)
        {
            this.usedTimes = v;
            setModified(true);
        }


    }

       
        
    private static List fieldNames = null;

    /**
     * Generate a list of field names.
     *
     * @return a list of field names
     */
    public static synchronized List getFieldNames()
    {
        if (fieldNames == null)
        {
            fieldNames = new ArrayList();
            fieldNames.add("Id");
            fieldNames.add("Content");
            fieldNames.add("Answer");
            fieldNames.add("Img");
            fieldNames.add("TixingId");
            fieldNames.add("MaterialId");
            fieldNames.add("MaterialKechengId");
            fieldNames.add("KnowledgePointId");
            fieldNames.add("WordsLevel");
            fieldNames.add("Tags");
            fieldNames.add("Fenci");
            fieldNames.add("Remark");
            fieldNames.add("Member");
            fieldNames.add("CreateTime");
            fieldNames.add("CreateMemberId");
            fieldNames.add("CreateMember");
            fieldNames.add("ModifyTime");
            fieldNames.add("ModifyMemberId");
            fieldNames.add("ModifyMember");
            fieldNames.add("ImgA");
            fieldNames.add("ImgB");
            fieldNames.add("ImgC");
            fieldNames.add("ImgD");
            fieldNames.add("ImgE");
            fieldNames.add("ImgF");
            fieldNames.add("UsedTimes");
            fieldNames = Collections.unmodifiableList(fieldNames);
        }
        return fieldNames;
    }

    /**
     * Retrieves a field from the object by field (Java) name passed in as a String.
     *
     * @param name field name
     * @return value
     */
    public Object getByName(String name)
    {
        if (name.equals("Id"))
        {
            return new Integer(getId());
        }
        if (name.equals("Content"))
        {
            return getContent();
        }
        if (name.equals("Answer"))
        {
            return getAnswer();
        }
        if (name.equals("Img"))
        {
            return getImg();
        }
        if (name.equals("TixingId"))
        {
            return new Integer(getTixingId());
        }
        if (name.equals("MaterialId"))
        {
            return new Integer(getMaterialId());
        }
        if (name.equals("MaterialKechengId"))
        {
            return new Integer(getMaterialKechengId());
        }
        if (name.equals("KnowledgePointId"))
        {
            return getKnowledgePointId();
        }
        if (name.equals("WordsLevel"))
        {
            return getWordsLevel();
        }
        if (name.equals("Tags"))
        {
            return getTags();
        }
        if (name.equals("Fenci"))
        {
            return getFenci();
        }
        if (name.equals("Remark"))
        {
            return getRemark();
        }
        if (name.equals("Member"))
        {
            return getMember();
        }
        if (name.equals("CreateTime"))
        {
            return getCreateTime();
        }
        if (name.equals("CreateMemberId"))
        {
            return new Integer(getCreateMemberId());
        }
        if (name.equals("CreateMember"))
        {
            return getCreateMember();
        }
        if (name.equals("ModifyTime"))
        {
            return getModifyTime();
        }
        if (name.equals("ModifyMemberId"))
        {
            return new Integer(getModifyMemberId());
        }
        if (name.equals("ModifyMember"))
        {
            return getModifyMember();
        }
        if (name.equals("ImgA"))
        {
            return getImgA();
        }
        if (name.equals("ImgB"))
        {
            return getImgB();
        }
        if (name.equals("ImgC"))
        {
            return getImgC();
        }
        if (name.equals("ImgD"))
        {
            return getImgD();
        }
        if (name.equals("ImgE"))
        {
            return getImgE();
        }
        if (name.equals("ImgF"))
        {
            return getImgF();
        }
        if (name.equals("UsedTimes"))
        {
            return new Integer(getUsedTimes());
        }
        return null;
    }

    /**
     * Set a field in the object by field (Java) name.
     *
     * @param name field name
     * @param value field value
     * @return True if value was set, false if not (invalid name / protected field).
     * @throws IllegalArgumentException if object type of value does not match field object type.
     * @throws TorqueException If a problem occurs with the set[Field] method.
     */
    public boolean setByName(String name, Object value )
        throws TorqueException, IllegalArgumentException
    {
        if (name.equals("Id"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setId(((Integer) value).intValue());
            return true;
        }
        if (name.equals("Content"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setContent((String) value);
            return true;
        }
        if (name.equals("Answer"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setAnswer((String) value);
            return true;
        }
        if (name.equals("Img"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setImg((String) value);
            return true;
        }
        if (name.equals("TixingId"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setTixingId(((Integer) value).intValue());
            return true;
        }
        if (name.equals("MaterialId"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setMaterialId(((Integer) value).intValue());
            return true;
        }
        if (name.equals("MaterialKechengId"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setMaterialKechengId(((Integer) value).intValue());
            return true;
        }
        if (name.equals("KnowledgePointId"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setKnowledgePointId((String) value);
            return true;
        }
        if (name.equals("WordsLevel"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setWordsLevel((String) value);
            return true;
        }
        if (name.equals("Tags"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setTags((String) value);
            return true;
        }
        if (name.equals("Fenci"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setFenci((String) value);
            return true;
        }
        if (name.equals("Remark"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setRemark((String) value);
            return true;
        }
        if (name.equals("Member"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setMember((String) value);
            return true;
        }
        if (name.equals("CreateTime"))
        {
            // Object fields can be null
            if (value != null && ! Date.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setCreateTime((Date) value);
            return true;
        }
        if (name.equals("CreateMemberId"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setCreateMemberId(((Integer) value).intValue());
            return true;
        }
        if (name.equals("CreateMember"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setCreateMember((String) value);
            return true;
        }
        if (name.equals("ModifyTime"))
        {
            // Object fields can be null
            if (value != null && ! Date.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setModifyTime((Date) value);
            return true;
        }
        if (name.equals("ModifyMemberId"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setModifyMemberId(((Integer) value).intValue());
            return true;
        }
        if (name.equals("ModifyMember"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setModifyMember((String) value);
            return true;
        }
        if (name.equals("ImgA"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setImgA((String) value);
            return true;
        }
        if (name.equals("ImgB"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setImgB((String) value);
            return true;
        }
        if (name.equals("ImgC"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setImgC((String) value);
            return true;
        }
        if (name.equals("ImgD"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setImgD((String) value);
            return true;
        }
        if (name.equals("ImgE"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setImgE((String) value);
            return true;
        }
        if (name.equals("ImgF"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setImgF((String) value);
            return true;
        }
        if (name.equals("UsedTimes"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setUsedTimes(((Integer) value).intValue());
            return true;
        }
        return false;
    }

    /**
     * Retrieves a field from the object by name passed in
     * as a String.  The String must be one of the static
     * Strings defined in this Class' Peer.
     *
     * @param name peer name
     * @return value
     */
    public Object getByPeerName(String name)
    {
        if (name.equals(QuestionBankPeer.ID))
        {
            return new Integer(getId());
        }
        if (name.equals(QuestionBankPeer.CONTENT))
        {
            return getContent();
        }
        if (name.equals(QuestionBankPeer.ANSWER))
        {
            return getAnswer();
        }
        if (name.equals(QuestionBankPeer.IMG))
        {
            return getImg();
        }
        if (name.equals(QuestionBankPeer.TIXING_ID))
        {
            return new Integer(getTixingId());
        }
        if (name.equals(QuestionBankPeer.MATERIAL_ID))
        {
            return new Integer(getMaterialId());
        }
        if (name.equals(QuestionBankPeer.MATERIAL_KECHENG_ID))
        {
            return new Integer(getMaterialKechengId());
        }
        if (name.equals(QuestionBankPeer.KNOWLEDGE_POINT_ID))
        {
            return getKnowledgePointId();
        }
        if (name.equals(QuestionBankPeer.WORDS_LEVEL))
        {
            return getWordsLevel();
        }
        if (name.equals(QuestionBankPeer.TAGS))
        {
            return getTags();
        }
        if (name.equals(QuestionBankPeer.FENCI))
        {
            return getFenci();
        }
        if (name.equals(QuestionBankPeer.REMARK))
        {
            return getRemark();
        }
        if (name.equals(QuestionBankPeer.MEMBER))
        {
            return getMember();
        }
        if (name.equals(QuestionBankPeer.CREATE_TIME))
        {
            return getCreateTime();
        }
        if (name.equals(QuestionBankPeer.CREATE_MEMBER_ID))
        {
            return new Integer(getCreateMemberId());
        }
        if (name.equals(QuestionBankPeer.CREATE_MEMBER))
        {
            return getCreateMember();
        }
        if (name.equals(QuestionBankPeer.MODIFY_TIME))
        {
            return getModifyTime();
        }
        if (name.equals(QuestionBankPeer.MODIFY_MEMBER_ID))
        {
            return new Integer(getModifyMemberId());
        }
        if (name.equals(QuestionBankPeer.MODIFY_MEMBER))
        {
            return getModifyMember();
        }
        if (name.equals(QuestionBankPeer.IMG_A))
        {
            return getImgA();
        }
        if (name.equals(QuestionBankPeer.IMG_B))
        {
            return getImgB();
        }
        if (name.equals(QuestionBankPeer.IMG_C))
        {
            return getImgC();
        }
        if (name.equals(QuestionBankPeer.IMG_D))
        {
            return getImgD();
        }
        if (name.equals(QuestionBankPeer.IMG_E))
        {
            return getImgE();
        }
        if (name.equals(QuestionBankPeer.IMG_F))
        {
            return getImgF();
        }
        if (name.equals(QuestionBankPeer.USED_TIMES))
        {
            return new Integer(getUsedTimes());
        }
        return null;
    }

    /**
     * Set field values by Peer Field Name
     *
     * @param name field name
     * @param value field value
     * @return True if value was set, false if not (invalid name / protected field).
     * @throws IllegalArgumentException if object type of value does not match field object type.
     * @throws TorqueException If a problem occurs with the set[Field] method.
     */
    public boolean setByPeerName(String name, Object value)
        throws TorqueException, IllegalArgumentException
    {
      if (QuestionBankPeer.ID.equals(name))
        {
            return setByName("Id", value);
        }
      if (QuestionBankPeer.CONTENT.equals(name))
        {
            return setByName("Content", value);
        }
      if (QuestionBankPeer.ANSWER.equals(name))
        {
            return setByName("Answer", value);
        }
      if (QuestionBankPeer.IMG.equals(name))
        {
            return setByName("Img", value);
        }
      if (QuestionBankPeer.TIXING_ID.equals(name))
        {
            return setByName("TixingId", value);
        }
      if (QuestionBankPeer.MATERIAL_ID.equals(name))
        {
            return setByName("MaterialId", value);
        }
      if (QuestionBankPeer.MATERIAL_KECHENG_ID.equals(name))
        {
            return setByName("MaterialKechengId", value);
        }
      if (QuestionBankPeer.KNOWLEDGE_POINT_ID.equals(name))
        {
            return setByName("KnowledgePointId", value);
        }
      if (QuestionBankPeer.WORDS_LEVEL.equals(name))
        {
            return setByName("WordsLevel", value);
        }
      if (QuestionBankPeer.TAGS.equals(name))
        {
            return setByName("Tags", value);
        }
      if (QuestionBankPeer.FENCI.equals(name))
        {
            return setByName("Fenci", value);
        }
      if (QuestionBankPeer.REMARK.equals(name))
        {
            return setByName("Remark", value);
        }
      if (QuestionBankPeer.MEMBER.equals(name))
        {
            return setByName("Member", value);
        }
      if (QuestionBankPeer.CREATE_TIME.equals(name))
        {
            return setByName("CreateTime", value);
        }
      if (QuestionBankPeer.CREATE_MEMBER_ID.equals(name))
        {
            return setByName("CreateMemberId", value);
        }
      if (QuestionBankPeer.CREATE_MEMBER.equals(name))
        {
            return setByName("CreateMember", value);
        }
      if (QuestionBankPeer.MODIFY_TIME.equals(name))
        {
            return setByName("ModifyTime", value);
        }
      if (QuestionBankPeer.MODIFY_MEMBER_ID.equals(name))
        {
            return setByName("ModifyMemberId", value);
        }
      if (QuestionBankPeer.MODIFY_MEMBER.equals(name))
        {
            return setByName("ModifyMember", value);
        }
      if (QuestionBankPeer.IMG_A.equals(name))
        {
            return setByName("ImgA", value);
        }
      if (QuestionBankPeer.IMG_B.equals(name))
        {
            return setByName("ImgB", value);
        }
      if (QuestionBankPeer.IMG_C.equals(name))
        {
            return setByName("ImgC", value);
        }
      if (QuestionBankPeer.IMG_D.equals(name))
        {
            return setByName("ImgD", value);
        }
      if (QuestionBankPeer.IMG_E.equals(name))
        {
            return setByName("ImgE", value);
        }
      if (QuestionBankPeer.IMG_F.equals(name))
        {
            return setByName("ImgF", value);
        }
      if (QuestionBankPeer.USED_TIMES.equals(name))
        {
            return setByName("UsedTimes", value);
        }
        return false;
    }

    /**
     * Retrieves a field from the object by Position as specified
     * in the xml schema.  Zero-based.
     *
     * @param pos position in xml schema
     * @return value
     */
    public Object getByPosition(int pos)
    {
        if (pos == 0)
        {
            return new Integer(getId());
        }
        if (pos == 1)
        {
            return getContent();
        }
        if (pos == 2)
        {
            return getAnswer();
        }
        if (pos == 3)
        {
            return getImg();
        }
        if (pos == 4)
        {
            return new Integer(getTixingId());
        }
        if (pos == 5)
        {
            return new Integer(getMaterialId());
        }
        if (pos == 6)
        {
            return new Integer(getMaterialKechengId());
        }
        if (pos == 7)
        {
            return getKnowledgePointId();
        }
        if (pos == 8)
        {
            return getWordsLevel();
        }
        if (pos == 9)
        {
            return getTags();
        }
        if (pos == 10)
        {
            return getFenci();
        }
        if (pos == 11)
        {
            return getRemark();
        }
        if (pos == 12)
        {
            return getMember();
        }
        if (pos == 13)
        {
            return getCreateTime();
        }
        if (pos == 14)
        {
            return new Integer(getCreateMemberId());
        }
        if (pos == 15)
        {
            return getCreateMember();
        }
        if (pos == 16)
        {
            return getModifyTime();
        }
        if (pos == 17)
        {
            return new Integer(getModifyMemberId());
        }
        if (pos == 18)
        {
            return getModifyMember();
        }
        if (pos == 19)
        {
            return getImgA();
        }
        if (pos == 20)
        {
            return getImgB();
        }
        if (pos == 21)
        {
            return getImgC();
        }
        if (pos == 22)
        {
            return getImgD();
        }
        if (pos == 23)
        {
            return getImgE();
        }
        if (pos == 24)
        {
            return getImgF();
        }
        if (pos == 25)
        {
            return new Integer(getUsedTimes());
        }
        return null;
    }

    /**
     * Set field values by its position (zero based) in the XML schema.
     *
     * @param position The field position
     * @param value field value
     * @return True if value was set, false if not (invalid position / protected field).
     * @throws IllegalArgumentException if object type of value does not match field object type.
     * @throws TorqueException If a problem occurs with the set[Field] method.
     */
    public boolean setByPosition(int position, Object value)
        throws TorqueException, IllegalArgumentException
    {
    if (position == 0)
        {
            return setByName("Id", value);
        }
    if (position == 1)
        {
            return setByName("Content", value);
        }
    if (position == 2)
        {
            return setByName("Answer", value);
        }
    if (position == 3)
        {
            return setByName("Img", value);
        }
    if (position == 4)
        {
            return setByName("TixingId", value);
        }
    if (position == 5)
        {
            return setByName("MaterialId", value);
        }
    if (position == 6)
        {
            return setByName("MaterialKechengId", value);
        }
    if (position == 7)
        {
            return setByName("KnowledgePointId", value);
        }
    if (position == 8)
        {
            return setByName("WordsLevel", value);
        }
    if (position == 9)
        {
            return setByName("Tags", value);
        }
    if (position == 10)
        {
            return setByName("Fenci", value);
        }
    if (position == 11)
        {
            return setByName("Remark", value);
        }
    if (position == 12)
        {
            return setByName("Member", value);
        }
    if (position == 13)
        {
            return setByName("CreateTime", value);
        }
    if (position == 14)
        {
            return setByName("CreateMemberId", value);
        }
    if (position == 15)
        {
            return setByName("CreateMember", value);
        }
    if (position == 16)
        {
            return setByName("ModifyTime", value);
        }
    if (position == 17)
        {
            return setByName("ModifyMemberId", value);
        }
    if (position == 18)
        {
            return setByName("ModifyMember", value);
        }
    if (position == 19)
        {
            return setByName("ImgA", value);
        }
    if (position == 20)
        {
            return setByName("ImgB", value);
        }
    if (position == 21)
        {
            return setByName("ImgC", value);
        }
    if (position == 22)
        {
            return setByName("ImgD", value);
        }
    if (position == 23)
        {
            return setByName("ImgE", value);
        }
    if (position == 24)
        {
            return setByName("ImgF", value);
        }
    if (position == 25)
        {
            return setByName("UsedTimes", value);
        }
        return false;
    }
     
    /**
     * Stores the object in the database.  If the object is new,
     * it inserts it; otherwise an update is performed.
     *
     * @throws Exception
     */
    public void save() throws Exception
    {
        save(QuestionBankPeer.DATABASE_NAME);
    }

    /**
     * Stores the object in the database.  If the object is new,
     * it inserts it; otherwise an update is performed.
     * Note: this code is here because the method body is
     * auto-generated conditionally and therefore needs to be
     * in this file instead of in the super class, BaseObject.
     *
     * @param dbName
     * @throws TorqueException
     */
    public void save(String dbName) throws TorqueException
    {
        Connection con = null;
        try
        {
            con = Transaction.begin(dbName);
            save(con);
            Transaction.commit(con);
        }
        catch(TorqueException e)
        {
            Transaction.safeRollback(con);
            throw e;
        }
    }

    /** flag to prevent endless save loop, if this object is referenced
        by another object which falls in this transaction. */
    private boolean alreadyInSave = false;
    /**
     * Stores the object in the database.  If the object is new,
     * it inserts it; otherwise an update is performed.  This method
     * is meant to be used as part of a transaction, otherwise use
     * the save() method and the connection details will be handled
     * internally
     *
     * @param con
     * @throws TorqueException
     */
    public void save(Connection con) throws TorqueException
    {
        if (!alreadyInSave)
        {
            alreadyInSave = true;



            // If this object has been modified, then save it to the database.
            if (isModified())
            {
                if (isNew())
                {
                    QuestionBankPeer.doInsert((QuestionBank) this, con);
                    setNew(false);
                }
                else
                {
                    QuestionBankPeer.doUpdate((QuestionBank) this, con);
                }
            }

            alreadyInSave = false;
        }
    }


    /**
     * Set the PrimaryKey using ObjectKey.
     *
     * @param key id ObjectKey
     */
    public void setPrimaryKey(ObjectKey key)
        
    {
        setId(((NumberKey) key).intValue());
    }

    /**
     * Set the PrimaryKey using a String.
     *
     * @param key
     */
    public void setPrimaryKey(String key) 
    {
        setId(Integer.parseInt(key));
    }


    /**
     * returns an id that differentiates this object from others
     * of its class.
     */
    public ObjectKey getPrimaryKey()
    {
        return SimpleKey.keyFor(getId());
    }
 

    /**
     * Makes a copy of this object.
     * It creates a new object filling in the simple attributes.
     * It then fills all the association collections and sets the
     * related objects to isNew=true.
     */
    public QuestionBank copy() throws TorqueException
    {
        return copy(true);
    }

    /**
     * Makes a copy of this object using connection.
     * It creates a new object filling in the simple attributes.
     * It then fills all the association collections and sets the
     * related objects to isNew=true.
     *
     * @param con the database connection to read associated objects.
     */
    public QuestionBank copy(Connection con) throws TorqueException
    {
        return copy(true, con);
    }

    /**
     * Makes a copy of this object.
     * It creates a new object filling in the simple attributes.
     * If the parameter deepcopy is true, it then fills all the
     * association collections and sets the related objects to
     * isNew=true.
     *
     * @param deepcopy whether to copy the associated objects.
     */
    public QuestionBank copy(boolean deepcopy) throws TorqueException
    {
        return copyInto(new QuestionBank(), deepcopy);
    }

    /**
     * Makes a copy of this object using connection.
     * It creates a new object filling in the simple attributes.
     * If the parameter deepcopy is true, it then fills all the
     * association collections and sets the related objects to
     * isNew=true.
     *
     * @param deepcopy whether to copy the associated objects.
     * @param con the database connection to read associated objects.
     */
    public QuestionBank copy(boolean deepcopy, Connection con) throws TorqueException
    {
        return copyInto(new QuestionBank(), deepcopy, con);
    }
  
    /**
     * Fills the copyObj with the contents of this object.
     * The associated objects are also copied and treated as new objects.
     *
     * @param copyObj the object to fill.
     */
    protected QuestionBank copyInto(QuestionBank copyObj) throws TorqueException
    {
        return copyInto(copyObj, true);
    }

  
    /**
     * Fills the copyObj with the contents of this object using connection.
     * The associated objects are also copied and treated as new objects.
     *
     * @param copyObj the object to fill.
     * @param con the database connection to read associated objects.
     */
    protected QuestionBank copyInto(QuestionBank copyObj, Connection con) throws TorqueException
    {
        return copyInto(copyObj, true, con);
    }
  
    /**
     * Fills the copyObj with the contents of this object.
     * If deepcopy is true, The associated objects are also copied
     * and treated as new objects.
     *
     * @param copyObj the object to fill.
     * @param deepcopy whether the associated objects should be copied.
     */
    protected QuestionBank copyInto(QuestionBank copyObj, boolean deepcopy) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setContent(content);
        copyObj.setAnswer(answer);
        copyObj.setImg(img);
        copyObj.setTixingId(tixingId);
        copyObj.setMaterialId(materialId);
        copyObj.setMaterialKechengId(materialKechengId);
        copyObj.setKnowledgePointId(knowledgePointId);
        copyObj.setWordsLevel(wordsLevel);
        copyObj.setTags(tags);
        copyObj.setFenci(fenci);
        copyObj.setRemark(remark);
        copyObj.setMember(member);
        copyObj.setCreateTime(createTime);
        copyObj.setCreateMemberId(createMemberId);
        copyObj.setCreateMember(createMember);
        copyObj.setModifyTime(modifyTime);
        copyObj.setModifyMemberId(modifyMemberId);
        copyObj.setModifyMember(modifyMember);
        copyObj.setImgA(imgA);
        copyObj.setImgB(imgB);
        copyObj.setImgC(imgC);
        copyObj.setImgD(imgD);
        copyObj.setImgE(imgE);
        copyObj.setImgF(imgF);
        copyObj.setUsedTimes(usedTimes);

        copyObj.setId( 0);

        if (deepcopy)
        {
        }
        return copyObj;
    }
        
    
    /**
     * Fills the copyObj with the contents of this object using connection.
     * If deepcopy is true, The associated objects are also copied
     * and treated as new objects.
     *
     * @param copyObj the object to fill.
     * @param deepcopy whether the associated objects should be copied.
     * @param con the database connection to read associated objects.
     */
    protected QuestionBank copyInto(QuestionBank copyObj, boolean deepcopy, Connection con) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setContent(content);
        copyObj.setAnswer(answer);
        copyObj.setImg(img);
        copyObj.setTixingId(tixingId);
        copyObj.setMaterialId(materialId);
        copyObj.setMaterialKechengId(materialKechengId);
        copyObj.setKnowledgePointId(knowledgePointId);
        copyObj.setWordsLevel(wordsLevel);
        copyObj.setTags(tags);
        copyObj.setFenci(fenci);
        copyObj.setRemark(remark);
        copyObj.setMember(member);
        copyObj.setCreateTime(createTime);
        copyObj.setCreateMemberId(createMemberId);
        copyObj.setCreateMember(createMember);
        copyObj.setModifyTime(modifyTime);
        copyObj.setModifyMemberId(modifyMemberId);
        copyObj.setModifyMember(modifyMember);
        copyObj.setImgA(imgA);
        copyObj.setImgB(imgB);
        copyObj.setImgC(imgC);
        copyObj.setImgD(imgD);
        copyObj.setImgE(imgE);
        copyObj.setImgF(imgF);
        copyObj.setUsedTimes(usedTimes);

        copyObj.setId( 0);

        if (deepcopy)
        {
        }
        return copyObj;
    }
    
    

    /**
     * returns a peer instance associated with this om.  Since Peer classes
     * are not to have any instance attributes, this method returns the
     * same instance for all member of this class. The method could therefore
     * be static, but this would prevent one from overriding the behavior.
     */
    public QuestionBankPeer getPeer()
    {
        return peer;
    }

    /**
     * Retrieves the TableMap object related to this Table data without
     * compiler warnings of using getPeer().getTableMap().
     *
     * @return The associated TableMap object.
     */
    public TableMap getTableMap() throws TorqueException
    {
        return QuestionBankPeer.getTableMap();
    }


    public String toString()
    {
        StringBuffer str = new StringBuffer();
        str.append("QuestionBank:\n");
        str.append("Id = ")
           .append(getId())
           .append("\n");
        str.append("Content = ")
           .append(getContent())
           .append("\n");
        str.append("Answer = ")
           .append(getAnswer())
           .append("\n");
        str.append("Img = ")
           .append(getImg())
           .append("\n");
        str.append("TixingId = ")
           .append(getTixingId())
           .append("\n");
        str.append("MaterialId = ")
           .append(getMaterialId())
           .append("\n");
        str.append("MaterialKechengId = ")
           .append(getMaterialKechengId())
           .append("\n");
        str.append("KnowledgePointId = ")
           .append(getKnowledgePointId())
           .append("\n");
        str.append("WordsLevel = ")
           .append(getWordsLevel())
           .append("\n");
        str.append("Tags = ")
           .append(getTags())
           .append("\n");
        str.append("Fenci = ")
           .append(getFenci())
           .append("\n");
        str.append("Remark = ")
           .append(getRemark())
           .append("\n");
        str.append("Member = ")
           .append(getMember())
           .append("\n");
        str.append("CreateTime = ")
           .append(getCreateTime())
           .append("\n");
        str.append("CreateMemberId = ")
           .append(getCreateMemberId())
           .append("\n");
        str.append("CreateMember = ")
           .append(getCreateMember())
           .append("\n");
        str.append("ModifyTime = ")
           .append(getModifyTime())
           .append("\n");
        str.append("ModifyMemberId = ")
           .append(getModifyMemberId())
           .append("\n");
        str.append("ModifyMember = ")
           .append(getModifyMember())
           .append("\n");
        str.append("ImgA = ")
           .append(getImgA())
           .append("\n");
        str.append("ImgB = ")
           .append(getImgB())
           .append("\n");
        str.append("ImgC = ")
           .append(getImgC())
           .append("\n");
        str.append("ImgD = ")
           .append(getImgD())
           .append("\n");
        str.append("ImgE = ")
           .append(getImgE())
           .append("\n");
        str.append("ImgF = ")
           .append(getImgF())
           .append("\n");
        str.append("UsedTimes = ")
           .append(getUsedTimes())
           .append("\n");
        return(str.toString());
    }
}
