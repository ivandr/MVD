package ru.rdtex.mvd.weapon.model.vo;

import oracle.jbo.RowIterator;
import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Mon Jul 09 11:34:13 MSD 2012
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class CountryViewRowImpl extends ViewRowImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. Do not modify.
     */
    public enum AttributesEnum {
        Code {
            public Object get(CountryViewRowImpl obj) {
                return obj.getCode();
            }

            public void put(CountryViewRowImpl obj, Object value) {
                obj.setCode((Number)value);
            }
        }
        ,
        Title {
            public Object get(CountryViewRowImpl obj) {
                return obj.getTitle();
            }

            public void put(CountryViewRowImpl obj, Object value) {
                obj.setTitle((String)value);
            }
        }
        ,
        UpdatedFlag {
            public Object get(CountryViewRowImpl obj) {
                return obj.getUpdatedFlag();
            }

            public void put(CountryViewRowImpl obj, Object value) {
                obj.setUpdatedFlag((Number)value);
            }
        }
        ,
        DeleteRow {
            public Object get(CountryViewRowImpl obj) {
                return obj.getDeleteRow();
            }

            public void put(CountryViewRowImpl obj, Object value) {
                obj.setDeleteRow((Boolean)value);
            }
        }
        ,
        EntPersonsView {
            public Object get(CountryViewRowImpl obj) {
                return obj.getEntPersonsView();
            }

            public void put(CountryViewRowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static int firstIndex = 0;

        public abstract Object get(CountryViewRowImpl object);

        public abstract void put(CountryViewRowImpl object, Object value);

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


    public static final int CODE = AttributesEnum.Code.index();
    public static final int TITLE = AttributesEnum.Title.index();
    public static final int UPDATEDFLAG = AttributesEnum.UpdatedFlag.index();
    public static final int DELETEROW = AttributesEnum.DeleteRow.index();
    public static final int ENTPERSONSVIEW = AttributesEnum.EntPersonsView.index();

    /**
     * This is the default constructor (do not remove).
     */
    public CountryViewRowImpl() {
    }

    /**
     * Gets Country entity object.
     * @return the Country
     */
    public EntityImpl getCountry() {
        return (EntityImpl)getEntity(0);
    }

    /**
     * Gets the attribute value for CODE using the alias name Code.
     * @return the CODE
     */
    public Number getCode() {
        return (Number) getAttributeInternal(CODE);
    }

    /**
     * Sets <code>value</code> as attribute value for CODE using the alias name Code.
     * @param value value to set the CODE
     */
    public void setCode(Number value) {
        setAttributeInternal(CODE, value);
    }

    /**
     * Gets the attribute value for TITLE using the alias name Title.
     * @return the TITLE
     */
    public String getTitle() {
        return (String) getAttributeInternal(TITLE);
    }

    /**
     * Sets <code>value</code> as attribute value for TITLE using the alias name Title.
     * @param value value to set the TITLE
     */
    public void setTitle(String value) {
        setAttributeInternal(TITLE, value);
    }

    /**
     * Gets the attribute value for UPDATED_FLAG using the alias name UpdatedFlag.
     * @return the UPDATED_FLAG
     */
    public Number getUpdatedFlag() {
        return (Number) getAttributeInternal(UPDATEDFLAG);
    }

    /**
     * Sets <code>value</code> as attribute value for UPDATED_FLAG using the alias name UpdatedFlag.
     * @param value value to set the UPDATED_FLAG
     */
    public void setUpdatedFlag(Number value) {
        setAttributeInternal(UPDATEDFLAG, value);
    }


    /**
     * Gets the attribute value for the calculated attribute DeleteRow.
     * @return the DeleteRow
     */
    public Boolean getDeleteRow() {
        return (Boolean) getAttributeInternal(DELETEROW);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute DeleteRow.
     * @param value value to set the  DeleteRow
     */
    public void setDeleteRow(Boolean value) {
        setAttributeInternal(DELETEROW, value);
    }

    /**
     * Gets the associated <code>RowIterator</code> using master-detail link EntPersonsView.
     */
    public RowIterator getEntPersonsView() {
        return (RowIterator)getAttributeInternal(ENTPERSONSVIEW);
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
