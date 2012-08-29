package ru.rdtex.mvd.weapon.model.vo.read;

import oracle.jbo.RowIterator;
import oracle.jbo.domain.Date;
import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Fri Aug 24 15:18:22 MSD 2012
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class RGunGunsViewRowImpl extends ViewRowImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. Do not modify.
     */
    public enum AttributesEnum {
        Id {
            public Object get(RGunGunsViewRowImpl obj) {
                return obj.getId();
            }

            public void put(RGunGunsViewRowImpl obj, Object value) {
                obj.setId((Number)value);
            }
        }
        ,
        EpId {
            public Object get(RGunGunsViewRowImpl obj) {
                return obj.getEpId();
            }

            public void put(RGunGunsViewRowImpl obj, Object value) {
                obj.setEpId((Number)value);
            }
        }
        ,
        DlId {
            public Object get(RGunGunsViewRowImpl obj) {
                return obj.getDlId();
            }

            public void put(RGunGunsViewRowImpl obj, Object value) {
                obj.setDlId((Number)value);
            }
        }
        ,
        DpId {
            public Object get(RGunGunsViewRowImpl obj) {
                return obj.getDpId();
            }

            public void put(RGunGunsViewRowImpl obj, Object value) {
                obj.setDpId((Number)value);
            }
        }
        ,
        KindTitle {
            public Object get(RGunGunsViewRowImpl obj) {
                return obj.getKindTitle();
            }

            public void put(RGunGunsViewRowImpl obj, Object value) {
                obj.setKindTitle((String)value);
            }
        }
        ,
        ModelTitle {
            public Object get(RGunGunsViewRowImpl obj) {
                return obj.getModelTitle();
            }

            public void put(RGunGunsViewRowImpl obj, Object value) {
                obj.setModelTitle((String)value);
            }
        }
        ,
        GunId {
            public Object get(RGunGunsViewRowImpl obj) {
                return obj.getGunId();
            }

            public void put(RGunGunsViewRowImpl obj, Object value) {
                obj.setGunId((Number)value);
            }
        }
        ,
        CodegunCode {
            public Object get(RGunGunsViewRowImpl obj) {
                return obj.getCodegunCode();
            }

            public void put(RGunGunsViewRowImpl obj, Object value) {
                obj.setCodegunCode((Number)value);
            }
        }
        ,
        Series {
            public Object get(RGunGunsViewRowImpl obj) {
                return obj.getSeries();
            }

            public void put(RGunGunsViewRowImpl obj, Object value) {
                obj.setSeries((String)value);
            }
        }
        ,
        Numb {
            public Object get(RGunGunsViewRowImpl obj) {
                return obj.getNumb();
            }

            public void put(RGunGunsViewRowImpl obj, Object value) {
                obj.setNumb((String)value);
            }
        }
        ,
        MakeYear {
            public Object get(RGunGunsViewRowImpl obj) {
                return obj.getMakeYear();
            }

            public void put(RGunGunsViewRowImpl obj, Object value) {
                obj.setMakeYear((Number)value);
            }
        }
        ,
        License {
            public Object get(RGunGunsViewRowImpl obj) {
                return obj.getLicense();
            }

            public void put(RGunGunsViewRowImpl obj, Object value) {
                obj.setLicense((String)value);
            }
        }
        ,
        Permission {
            public Object get(RGunGunsViewRowImpl obj) {
                return obj.getPermission();
            }

            public void put(RGunGunsViewRowImpl obj, Object value) {
                obj.setPermission((String)value);
            }
        }
        ,
        BeginDate {
            public Object get(RGunGunsViewRowImpl obj) {
                return obj.getBeginDate();
            }

            public void put(RGunGunsViewRowImpl obj, Object value) {
                obj.setBeginDate((Date)value);
            }
        }
        ,
        EndDate {
            public Object get(RGunGunsViewRowImpl obj) {
                return obj.getEndDate();
            }

            public void put(RGunGunsViewRowImpl obj, Object value) {
                obj.setEndDate((Date)value);
            }
        }
        ,
        StateName {
            public Object get(RGunGunsViewRowImpl obj) {
                return obj.getStateName();
            }

            public void put(RGunGunsViewRowImpl obj, Object value) {
                obj.setStateName((String)value);
            }
        }
        ,
        GunGunsView {
            public Object get(RGunGunsViewRowImpl obj) {
                return obj.getGunGunsView();
            }

            public void put(RGunGunsViewRowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static int firstIndex = 0;

        public abstract Object get(RGunGunsViewRowImpl object);

        public abstract void put(RGunGunsViewRowImpl object, Object value);

        public int index() {
            return AttributesEnum.firstIndex() + ordinal();
        }

        public static int firstIndex() {
            return firstIndex;
        }

        public static int count() {
            return AttributesEnum.firstIndex() + AttributesEnum.staticValues().length;
        }

        public static AttributesEnum[] staticValues() {
            if (vals == null) {
                vals = AttributesEnum.values();
            }
            return vals;
        }
    }


    public static final int ID = AttributesEnum.Id.index();
    public static final int EPID = AttributesEnum.EpId.index();
    public static final int DLID = AttributesEnum.DlId.index();
    public static final int DPID = AttributesEnum.DpId.index();
    public static final int KINDTITLE = AttributesEnum.KindTitle.index();
    public static final int MODELTITLE = AttributesEnum.ModelTitle.index();
    public static final int GUNID = AttributesEnum.GunId.index();
    public static final int CODEGUNCODE = AttributesEnum.CodegunCode.index();
    public static final int SERIES = AttributesEnum.Series.index();
    public static final int NUMB = AttributesEnum.Numb.index();
    public static final int MAKEYEAR = AttributesEnum.MakeYear.index();
    public static final int LICENSE = AttributesEnum.License.index();
    public static final int PERMISSION = AttributesEnum.Permission.index();
    public static final int BEGINDATE = AttributesEnum.BeginDate.index();
    public static final int ENDDATE = AttributesEnum.EndDate.index();
    public static final int STATENAME = AttributesEnum.StateName.index();
    public static final int GUNGUNSVIEW = AttributesEnum.GunGunsView.index();

    /**
     * This is the default constructor (do not remove).
     */
    public RGunGunsViewRowImpl() {
    }

    /**
     * Gets the attribute value for the calculated attribute Id.
     * @return the Id
     */
    public Number getId() {
        return (Number) getAttributeInternal(ID);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute Id.
     * @param value value to set the  Id
     */
    public void setId(Number value) {
        setAttributeInternal(ID, value);
    }

    /**
     * Gets the attribute value for the calculated attribute EpId.
     * @return the EpId
     */
    public Number getEpId() {
        return (Number) getAttributeInternal(EPID);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute EpId.
     * @param value value to set the  EpId
     */
    public void setEpId(Number value) {
        setAttributeInternal(EPID, value);
    }

    /**
     * Gets the attribute value for the calculated attribute DlId.
     * @return the DlId
     */
    public Number getDlId() {
        return (Number) getAttributeInternal(DLID);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute DlId.
     * @param value value to set the  DlId
     */
    public void setDlId(Number value) {
        setAttributeInternal(DLID, value);
    }

    /**
     * Gets the attribute value for the calculated attribute DpId.
     * @return the DpId
     */
    public Number getDpId() {
        return (Number) getAttributeInternal(DPID);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute DpId.
     * @param value value to set the  DpId
     */
    public void setDpId(Number value) {
        setAttributeInternal(DPID, value);
    }

    /**
     * Gets the attribute value for the calculated attribute KindTitle.
     * @return the KindTitle
     */
    public String getKindTitle() {
        return (String) getAttributeInternal(KINDTITLE);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute KindTitle.
     * @param value value to set the  KindTitle
     */
    public void setKindTitle(String value) {
        setAttributeInternal(KINDTITLE, value);
    }

    /**
     * Gets the attribute value for the calculated attribute ModelTitle.
     * @return the ModelTitle
     */
    public String getModelTitle() {
        return (String) getAttributeInternal(MODELTITLE);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute ModelTitle.
     * @param value value to set the  ModelTitle
     */
    public void setModelTitle(String value) {
        setAttributeInternal(MODELTITLE, value);
    }

    /**
     * Gets the attribute value for the calculated attribute GunId.
     * @return the GunId
     */
    public Number getGunId() {
        return (Number) getAttributeInternal(GUNID);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute GunId.
     * @param value value to set the  GunId
     */
    public void setGunId(Number value) {
        setAttributeInternal(GUNID, value);
    }

    /**
     * Gets the attribute value for the calculated attribute CodegunCode.
     * @return the CodegunCode
     */
    public Number getCodegunCode() {
        return (Number) getAttributeInternal(CODEGUNCODE);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute CodegunCode.
     * @param value value to set the  CodegunCode
     */
    public void setCodegunCode(Number value) {
        setAttributeInternal(CODEGUNCODE, value);
    }

    /**
     * Gets the attribute value for the calculated attribute Series.
     * @return the Series
     */
    public String getSeries() {
        return (String) getAttributeInternal(SERIES);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute Series.
     * @param value value to set the  Series
     */
    public void setSeries(String value) {
        setAttributeInternal(SERIES, value);
    }

    /**
     * Gets the attribute value for the calculated attribute Numb.
     * @return the Numb
     */
    public String getNumb() {
        return (String) getAttributeInternal(NUMB);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute Numb.
     * @param value value to set the  Numb
     */
    public void setNumb(String value) {
        setAttributeInternal(NUMB, value);
    }

    /**
     * Gets the attribute value for the calculated attribute MakeYear.
     * @return the MakeYear
     */
    public Number getMakeYear() {
        return (Number) getAttributeInternal(MAKEYEAR);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute MakeYear.
     * @param value value to set the  MakeYear
     */
    public void setMakeYear(Number value) {
        setAttributeInternal(MAKEYEAR, value);
    }

    /**
     * Gets the attribute value for the calculated attribute License.
     * @return the License
     */
    public String getLicense() {
        return (String) getAttributeInternal(LICENSE);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute License.
     * @param value value to set the  License
     */
    public void setLicense(String value) {
        setAttributeInternal(LICENSE, value);
    }

    /**
     * Gets the attribute value for the calculated attribute Permission.
     * @return the Permission
     */
    public String getPermission() {
        return (String) getAttributeInternal(PERMISSION);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute Permission.
     * @param value value to set the  Permission
     */
    public void setPermission(String value) {
        setAttributeInternal(PERMISSION, value);
    }

    /**
     * Gets the attribute value for the calculated attribute BeginDate.
     * @return the BeginDate
     */
    public Date getBeginDate() {
        return (Date) getAttributeInternal(BEGINDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute BeginDate.
     * @param value value to set the  BeginDate
     */
    public void setBeginDate(Date value) {
        setAttributeInternal(BEGINDATE, value);
    }

    /**
     * Gets the attribute value for the calculated attribute EndDate.
     * @return the EndDate
     */
    public Date getEndDate() {
        return (Date) getAttributeInternal(ENDDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute EndDate.
     * @param value value to set the  EndDate
     */
    public void setEndDate(Date value) {
        setAttributeInternal(ENDDATE, value);
    }

    /**
     * Gets the attribute value for the calculated attribute StateName.
     * @return the StateName
     */
    public String getStateName() {
        return (String) getAttributeInternal(STATENAME);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute StateName.
     * @param value value to set the  StateName
     */
    public void setStateName(String value) {
        setAttributeInternal(STATENAME, value);
    }

    /**
     * Gets the associated <code>RowIterator</code> using master-detail link GunGunsView.
     */
    public RowIterator getGunGunsView() {
        return (RowIterator)getAttributeInternal(GUNGUNSVIEW);
    }


    /**
     * getAttrInvokeAccessor: generated method. Do not modify.
     * @param index the index identifying the attribute
     * @param attrDef the attribute

     * @return the attribute value
     * @throws Exception
     */
    protected Object getAttrInvokeAccessor(int index,
                                           AttributeDefImpl attrDef) throws Exception {
        if ((index >= AttributesEnum.firstIndex()) && (index < AttributesEnum.count())) {
            return AttributesEnum.staticValues()[index - AttributesEnum.firstIndex()].get(this);
        }
        return super.getAttrInvokeAccessor(index, attrDef);
    }

    /**
     * setAttrInvokeAccessor: generated method. Do not modify.
     * @param index the index identifying the attribute
     * @param value the value to assign to the attribute
     * @param attrDef the attribute

     * @throws Exception
     */
    protected void setAttrInvokeAccessor(int index, Object value,
                                         AttributeDefImpl attrDef) throws Exception {
        if ((index >= AttributesEnum.firstIndex()) && (index < AttributesEnum.count())) {
            AttributesEnum.staticValues()[index - AttributesEnum.firstIndex()].put(this, value);
            return;
        }
        super.setAttrInvokeAccessor(index, value, attrDef);
    }
}