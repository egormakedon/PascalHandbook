/**
 * Autogenerated by Thrift Compiler (0.11.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package rpcserver.thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.11.0)", date = "2018-03-19")
public class Author implements org.apache.thrift.TBase<Author, Author._Fields>, java.io.Serializable, Cloneable, Comparable<Author> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("Author");

  private static final org.apache.thrift.protocol.TField AUTHOR_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("authorId", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("name", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField SURNAME_FIELD_DESC = new org.apache.thrift.protocol.TField("surname", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField COUNTRY_FIELD_DESC = new org.apache.thrift.protocol.TField("country", org.apache.thrift.protocol.TType.STRING, (short)4);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new AuthorStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new AuthorTupleSchemeFactory();

  public int authorId; // required
  public java.lang.String name; // required
  public java.lang.String surname; // required
  public java.lang.String country; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    AUTHOR_ID((short)1, "authorId"),
    NAME((short)2, "name"),
    SURNAME((short)3, "surname"),
    COUNTRY((short)4, "country");

    private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // AUTHOR_ID
          return AUTHOR_ID;
        case 2: // NAME
          return NAME;
        case 3: // SURNAME
          return SURNAME;
        case 4: // COUNTRY
          return COUNTRY;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(java.lang.String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final java.lang.String _fieldName;

    _Fields(short thriftId, java.lang.String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public java.lang.String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __AUTHORID_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.AUTHOR_ID, new org.apache.thrift.meta_data.FieldMetaData("authorId", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.NAME, new org.apache.thrift.meta_data.FieldMetaData("name", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.SURNAME, new org.apache.thrift.meta_data.FieldMetaData("surname", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.COUNTRY, new org.apache.thrift.meta_data.FieldMetaData("country", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(Author.class, metaDataMap);
  }

  public Author() {
  }

  public Author(
    int authorId,
    java.lang.String name,
    java.lang.String surname,
    java.lang.String country)
  {
    this();
    this.authorId = authorId;
    setAuthorIdIsSet(true);
    this.name = name;
    this.surname = surname;
    this.country = country;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public Author(Author other) {
    __isset_bitfield = other.__isset_bitfield;
    this.authorId = other.authorId;
    if (other.isSetName()) {
      this.name = other.name;
    }
    if (other.isSetSurname()) {
      this.surname = other.surname;
    }
    if (other.isSetCountry()) {
      this.country = other.country;
    }
  }

  public Author deepCopy() {
    return new Author(this);
  }

  @Override
  public void clear() {
    setAuthorIdIsSet(false);
    this.authorId = 0;
    this.name = null;
    this.surname = null;
    this.country = null;
  }

  public int getAuthorId() {
    return this.authorId;
  }

  public Author setAuthorId(int authorId) {
    this.authorId = authorId;
    setAuthorIdIsSet(true);
    return this;
  }

  public void unsetAuthorId() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __AUTHORID_ISSET_ID);
  }

  /** Returns true if field authorId is set (has been assigned a value) and false otherwise */
  public boolean isSetAuthorId() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __AUTHORID_ISSET_ID);
  }

  public void setAuthorIdIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __AUTHORID_ISSET_ID, value);
  }

  public java.lang.String getName() {
    return this.name;
  }

  public Author setName(java.lang.String name) {
    this.name = name;
    return this;
  }

  public void unsetName() {
    this.name = null;
  }

  /** Returns true if field name is set (has been assigned a value) and false otherwise */
  public boolean isSetName() {
    return this.name != null;
  }

  public void setNameIsSet(boolean value) {
    if (!value) {
      this.name = null;
    }
  }

  public java.lang.String getSurname() {
    return this.surname;
  }

  public Author setSurname(java.lang.String surname) {
    this.surname = surname;
    return this;
  }

  public void unsetSurname() {
    this.surname = null;
  }

  /** Returns true if field surname is set (has been assigned a value) and false otherwise */
  public boolean isSetSurname() {
    return this.surname != null;
  }

  public void setSurnameIsSet(boolean value) {
    if (!value) {
      this.surname = null;
    }
  }

  public java.lang.String getCountry() {
    return this.country;
  }

  public Author setCountry(java.lang.String country) {
    this.country = country;
    return this;
  }

  public void unsetCountry() {
    this.country = null;
  }

  /** Returns true if field country is set (has been assigned a value) and false otherwise */
  public boolean isSetCountry() {
    return this.country != null;
  }

  public void setCountryIsSet(boolean value) {
    if (!value) {
      this.country = null;
    }
  }

  public void setFieldValue(_Fields field, java.lang.Object value) {
    switch (field) {
    case AUTHOR_ID:
      if (value == null) {
        unsetAuthorId();
      } else {
        setAuthorId((java.lang.Integer)value);
      }
      break;

    case NAME:
      if (value == null) {
        unsetName();
      } else {
        setName((java.lang.String)value);
      }
      break;

    case SURNAME:
      if (value == null) {
        unsetSurname();
      } else {
        setSurname((java.lang.String)value);
      }
      break;

    case COUNTRY:
      if (value == null) {
        unsetCountry();
      } else {
        setCountry((java.lang.String)value);
      }
      break;

    }
  }

  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case AUTHOR_ID:
      return getAuthorId();

    case NAME:
      return getName();

    case SURNAME:
      return getSurname();

    case COUNTRY:
      return getCountry();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case AUTHOR_ID:
      return isSetAuthorId();
    case NAME:
      return isSetName();
    case SURNAME:
      return isSetSurname();
    case COUNTRY:
      return isSetCountry();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that == null)
      return false;
    if (that instanceof Author)
      return this.equals((Author)that);
    return false;
  }

  public boolean equals(Author that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_authorId = true;
    boolean that_present_authorId = true;
    if (this_present_authorId || that_present_authorId) {
      if (!(this_present_authorId && that_present_authorId))
        return false;
      if (this.authorId != that.authorId)
        return false;
    }

    boolean this_present_name = true && this.isSetName();
    boolean that_present_name = true && that.isSetName();
    if (this_present_name || that_present_name) {
      if (!(this_present_name && that_present_name))
        return false;
      if (!this.name.equals(that.name))
        return false;
    }

    boolean this_present_surname = true && this.isSetSurname();
    boolean that_present_surname = true && that.isSetSurname();
    if (this_present_surname || that_present_surname) {
      if (!(this_present_surname && that_present_surname))
        return false;
      if (!this.surname.equals(that.surname))
        return false;
    }

    boolean this_present_country = true && this.isSetCountry();
    boolean that_present_country = true && that.isSetCountry();
    if (this_present_country || that_present_country) {
      if (!(this_present_country && that_present_country))
        return false;
      if (!this.country.equals(that.country))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + authorId;

    hashCode = hashCode * 8191 + ((isSetName()) ? 131071 : 524287);
    if (isSetName())
      hashCode = hashCode * 8191 + name.hashCode();

    hashCode = hashCode * 8191 + ((isSetSurname()) ? 131071 : 524287);
    if (isSetSurname())
      hashCode = hashCode * 8191 + surname.hashCode();

    hashCode = hashCode * 8191 + ((isSetCountry()) ? 131071 : 524287);
    if (isSetCountry())
      hashCode = hashCode * 8191 + country.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(Author other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.valueOf(isSetAuthorId()).compareTo(other.isSetAuthorId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetAuthorId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.authorId, other.authorId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetName()).compareTo(other.isSetName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.name, other.name);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetSurname()).compareTo(other.isSetSurname());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSurname()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.surname, other.surname);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetCountry()).compareTo(other.isSetCountry());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCountry()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.country, other.country);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    scheme(iprot).read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    scheme(oprot).write(oprot, this);
  }

  @Override
  public java.lang.String toString() {
    java.lang.StringBuilder sb = new java.lang.StringBuilder("Author(");
    boolean first = true;

    sb.append("authorId:");
    sb.append(this.authorId);
    first = false;
    if (!first) sb.append(", ");
    sb.append("name:");
    if (this.name == null) {
      sb.append("null");
    } else {
      sb.append(this.name);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("surname:");
    if (this.surname == null) {
      sb.append("null");
    } else {
      sb.append(this.surname);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("country:");
    if (this.country == null) {
      sb.append("null");
    } else {
      sb.append(this.country);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class AuthorStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public AuthorStandardScheme getScheme() {
      return new AuthorStandardScheme();
    }
  }

  private static class AuthorStandardScheme extends org.apache.thrift.scheme.StandardScheme<Author> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, Author struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // AUTHOR_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.authorId = iprot.readI32();
              struct.setAuthorIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.name = iprot.readString();
              struct.setNameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // SURNAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.surname = iprot.readString();
              struct.setSurnameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // COUNTRY
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.country = iprot.readString();
              struct.setCountryIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, Author struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(AUTHOR_ID_FIELD_DESC);
      oprot.writeI32(struct.authorId);
      oprot.writeFieldEnd();
      if (struct.name != null) {
        oprot.writeFieldBegin(NAME_FIELD_DESC);
        oprot.writeString(struct.name);
        oprot.writeFieldEnd();
      }
      if (struct.surname != null) {
        oprot.writeFieldBegin(SURNAME_FIELD_DESC);
        oprot.writeString(struct.surname);
        oprot.writeFieldEnd();
      }
      if (struct.country != null) {
        oprot.writeFieldBegin(COUNTRY_FIELD_DESC);
        oprot.writeString(struct.country);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class AuthorTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public AuthorTupleScheme getScheme() {
      return new AuthorTupleScheme();
    }
  }

  private static class AuthorTupleScheme extends org.apache.thrift.scheme.TupleScheme<Author> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, Author struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetAuthorId()) {
        optionals.set(0);
      }
      if (struct.isSetName()) {
        optionals.set(1);
      }
      if (struct.isSetSurname()) {
        optionals.set(2);
      }
      if (struct.isSetCountry()) {
        optionals.set(3);
      }
      oprot.writeBitSet(optionals, 4);
      if (struct.isSetAuthorId()) {
        oprot.writeI32(struct.authorId);
      }
      if (struct.isSetName()) {
        oprot.writeString(struct.name);
      }
      if (struct.isSetSurname()) {
        oprot.writeString(struct.surname);
      }
      if (struct.isSetCountry()) {
        oprot.writeString(struct.country);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, Author struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(4);
      if (incoming.get(0)) {
        struct.authorId = iprot.readI32();
        struct.setAuthorIdIsSet(true);
      }
      if (incoming.get(1)) {
        struct.name = iprot.readString();
        struct.setNameIsSet(true);
      }
      if (incoming.get(2)) {
        struct.surname = iprot.readString();
        struct.setSurnameIsSet(true);
      }
      if (incoming.get(3)) {
        struct.country = iprot.readString();
        struct.setCountryIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

