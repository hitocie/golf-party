package com.xhills.golf_party.meta.course;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2011-09-06 08:23:37")
/** */
public final class HoleMeta extends org.slim3.datastore.ModelMeta<com.xhills.golf_party.model.course.Hole> {

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.xhills.golf_party.model.course.Hole, java.lang.Integer> backYard = new org.slim3.datastore.CoreAttributeMeta<com.xhills.golf_party.model.course.Hole, java.lang.Integer>(this, "backYard", "backYard", int.class);

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<com.xhills.golf_party.model.course.Hole, org.slim3.datastore.ModelRef<com.xhills.golf_party.model.course.Half>, com.xhills.golf_party.model.course.Half> halfRef = new org.slim3.datastore.ModelRefAttributeMeta<com.xhills.golf_party.model.course.Hole, org.slim3.datastore.ModelRef<com.xhills.golf_party.model.course.Half>, com.xhills.golf_party.model.course.Half>(this, "halfRef", "halfRef", org.slim3.datastore.ModelRef.class, com.xhills.golf_party.model.course.Half.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.xhills.golf_party.model.course.Hole, java.lang.Integer> handicap = new org.slim3.datastore.CoreAttributeMeta<com.xhills.golf_party.model.course.Hole, java.lang.Integer>(this, "handicap", "handicap", int.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.xhills.golf_party.model.course.Hole, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<com.xhills.golf_party.model.course.Hole, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.xhills.golf_party.model.course.Hole, java.lang.Integer> no = new org.slim3.datastore.CoreAttributeMeta<com.xhills.golf_party.model.course.Hole, java.lang.Integer>(this, "no", "no", int.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.xhills.golf_party.model.course.Hole, java.lang.Integer> par = new org.slim3.datastore.CoreAttributeMeta<com.xhills.golf_party.model.course.Hole, java.lang.Integer>(this, "par", "par", int.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.xhills.golf_party.model.course.Hole, java.lang.Integer> redYard = new org.slim3.datastore.CoreAttributeMeta<com.xhills.golf_party.model.course.Hole, java.lang.Integer>(this, "redYard", "redYard", int.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.xhills.golf_party.model.course.Hole, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<com.xhills.golf_party.model.course.Hole, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.xhills.golf_party.model.course.Hole, java.lang.Integer> whiteYard = new org.slim3.datastore.CoreAttributeMeta<com.xhills.golf_party.model.course.Hole, java.lang.Integer>(this, "whiteYard", "whiteYard", int.class);

    private static final HoleMeta slim3_singleton = new HoleMeta();

    /**
     * @return the singleton
     */
    public static HoleMeta get() {
       return slim3_singleton;
    }

    /** */
    public HoleMeta() {
        super("Hole", com.xhills.golf_party.model.course.Hole.class);
    }

    @Override
    public com.xhills.golf_party.model.course.Hole entityToModel(com.google.appengine.api.datastore.Entity entity) {
        com.xhills.golf_party.model.course.Hole model = new com.xhills.golf_party.model.course.Hole();
        model.setBackYard(longToPrimitiveInt((java.lang.Long) entity.getProperty("backYard")));
        if (model.getHalfRef() == null) {
            throw new NullPointerException("The property(halfRef) is null.");
        }
        model.getHalfRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("halfRef"));
        model.setHandicap(longToPrimitiveInt((java.lang.Long) entity.getProperty("handicap")));
        model.setKey(entity.getKey());
        model.setNo(longToPrimitiveInt((java.lang.Long) entity.getProperty("no")));
        model.setPar(longToPrimitiveInt((java.lang.Long) entity.getProperty("par")));
        model.setRedYard(longToPrimitiveInt((java.lang.Long) entity.getProperty("redYard")));
        model.setVersion((java.lang.Long) entity.getProperty("version"));
        model.setWhiteYard(longToPrimitiveInt((java.lang.Long) entity.getProperty("whiteYard")));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        com.xhills.golf_party.model.course.Hole m = (com.xhills.golf_party.model.course.Hole) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("backYard", m.getBackYard());
        if (m.getHalfRef() == null) {
            throw new NullPointerException("The property(halfRef) must not be null.");
        }
        entity.setProperty("halfRef", m.getHalfRef().getKey());
        entity.setProperty("handicap", m.getHandicap());
        entity.setProperty("no", m.getNo());
        entity.setProperty("par", m.getPar());
        entity.setProperty("redYard", m.getRedYard());
        entity.setProperty("version", m.getVersion());
        entity.setProperty("whiteYard", m.getWhiteYard());
        entity.setProperty("slim3.schemaVersion", 1);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        com.xhills.golf_party.model.course.Hole m = (com.xhills.golf_party.model.course.Hole) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        com.xhills.golf_party.model.course.Hole m = (com.xhills.golf_party.model.course.Hole) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        com.xhills.golf_party.model.course.Hole m = (com.xhills.golf_party.model.course.Hole) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
        com.xhills.golf_party.model.course.Hole m = (com.xhills.golf_party.model.course.Hole) model;
        if (m.getHalfRef() == null) {
            throw new NullPointerException("The property(halfRef) must not be null.");
        }
        m.getHalfRef().assignKeyIfNecessary(ds);
    }

    @Override
    protected void incrementVersion(Object model) {
        com.xhills.golf_party.model.course.Hole m = (com.xhills.golf_party.model.course.Hole) model;
        long version = m.getVersion() != null ? m.getVersion().longValue() : 0L;
        m.setVersion(Long.valueOf(version + 1L));
    }

    @Override
    protected void prePut(Object model) {
    }

    @Override
    public String getSchemaVersionName() {
        return "slim3.schemaVersion";
    }

    @Override
    public String getClassHierarchyListName() {
        return "slim3.classHierarchyList";
    }

    @Override
    protected boolean isCipherProperty(String propertyName) {
        return false;
    }

    @Override
    protected void modelToJson(org.slim3.datastore.json.JsonWriter writer, java.lang.Object model, int maxDepth, int currentDepth) {
        com.xhills.golf_party.model.course.Hole m = (com.xhills.golf_party.model.course.Hole) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        writer.setNextPropertyName("backYard");
        encoder0.encode(writer, m.getBackYard());
        if(m.getHalfRef() != null && m.getHalfRef().getKey() != null){
            writer.setNextPropertyName("halfRef");
            encoder0.encode(writer, m.getHalfRef(), maxDepth, currentDepth);
        }
        writer.setNextPropertyName("handicap");
        encoder0.encode(writer, m.getHandicap());
        if(m.getKey() != null){
            writer.setNextPropertyName("key");
            encoder0.encode(writer, m.getKey());
        }
        writer.setNextPropertyName("no");
        encoder0.encode(writer, m.getNo());
        writer.setNextPropertyName("par");
        encoder0.encode(writer, m.getPar());
        writer.setNextPropertyName("redYard");
        encoder0.encode(writer, m.getRedYard());
        if(m.getVersion() != null){
            writer.setNextPropertyName("version");
            encoder0.encode(writer, m.getVersion());
        }
        writer.setNextPropertyName("whiteYard");
        encoder0.encode(writer, m.getWhiteYard());
        writer.endObject();
    }

    @Override
    protected com.xhills.golf_party.model.course.Hole jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        com.xhills.golf_party.model.course.Hole m = new com.xhills.golf_party.model.course.Hole();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("backYard");
        m.setBackYard(decoder0.decode(reader, m.getBackYard()));
        reader = rootReader.newObjectReader("halfRef");
        decoder0.decode(reader, m.getHalfRef(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("handicap");
        m.setHandicap(decoder0.decode(reader, m.getHandicap()));
        reader = rootReader.newObjectReader("key");
        m.setKey(decoder0.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("no");
        m.setNo(decoder0.decode(reader, m.getNo()));
        reader = rootReader.newObjectReader("par");
        m.setPar(decoder0.decode(reader, m.getPar()));
        reader = rootReader.newObjectReader("redYard");
        m.setRedYard(decoder0.decode(reader, m.getRedYard()));
        reader = rootReader.newObjectReader("version");
        m.setVersion(decoder0.decode(reader, m.getVersion()));
        reader = rootReader.newObjectReader("whiteYard");
        m.setWhiteYard(decoder0.decode(reader, m.getWhiteYard()));
        return m;
    }
}