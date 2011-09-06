package com.xhills.golf_party.meta.course;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2011-09-06 23:47:20")
/** */
public final class HalfMeta extends org.slim3.datastore.ModelMeta<com.xhills.golf_party.model.course.Half> {

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<com.xhills.golf_party.model.course.Half, org.slim3.datastore.ModelRef<com.xhills.golf_party.model.course.Course>, com.xhills.golf_party.model.course.Course> courseRef = new org.slim3.datastore.ModelRefAttributeMeta<com.xhills.golf_party.model.course.Half, org.slim3.datastore.ModelRef<com.xhills.golf_party.model.course.Course>, com.xhills.golf_party.model.course.Course>(this, "courseRef", "courseRef", org.slim3.datastore.ModelRef.class, com.xhills.golf_party.model.course.Course.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.xhills.golf_party.model.course.Half, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<com.xhills.golf_party.model.course.Half, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.xhills.golf_party.model.course.Half> name = new org.slim3.datastore.StringAttributeMeta<com.xhills.golf_party.model.course.Half>(this, "name", "name");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.xhills.golf_party.model.course.Half, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<com.xhills.golf_party.model.course.Half, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final HalfMeta slim3_singleton = new HalfMeta();

    /**
     * @return the singleton
     */
    public static HalfMeta get() {
       return slim3_singleton;
    }

    /** */
    public HalfMeta() {
        super("Half", com.xhills.golf_party.model.course.Half.class);
    }

    @Override
    public com.xhills.golf_party.model.course.Half entityToModel(com.google.appengine.api.datastore.Entity entity) {
        com.xhills.golf_party.model.course.Half model = new com.xhills.golf_party.model.course.Half();
        if (model.getCourseRef() == null) {
            throw new NullPointerException("The property(courseRef) is null.");
        }
        model.getCourseRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("courseRef"));
        model.setKey(entity.getKey());
        model.setName((java.lang.String) entity.getProperty("name"));
        model.setVersion((java.lang.Long) entity.getProperty("version"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        com.xhills.golf_party.model.course.Half m = (com.xhills.golf_party.model.course.Half) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        if (m.getCourseRef() == null) {
            throw new NullPointerException("The property(courseRef) must not be null.");
        }
        entity.setProperty("courseRef", m.getCourseRef().getKey());
        entity.setProperty("name", m.getName());
        entity.setProperty("version", m.getVersion());
        entity.setProperty("slim3.schemaVersion", 1);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        com.xhills.golf_party.model.course.Half m = (com.xhills.golf_party.model.course.Half) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        com.xhills.golf_party.model.course.Half m = (com.xhills.golf_party.model.course.Half) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        com.xhills.golf_party.model.course.Half m = (com.xhills.golf_party.model.course.Half) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
        com.xhills.golf_party.model.course.Half m = (com.xhills.golf_party.model.course.Half) model;
        if (m.getCourseRef() == null) {
            throw new NullPointerException("The property(courseRef) must not be null.");
        }
        m.getCourseRef().assignKeyIfNecessary(ds);
    }

    @Override
    protected void incrementVersion(Object model) {
        com.xhills.golf_party.model.course.Half m = (com.xhills.golf_party.model.course.Half) model;
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
        com.xhills.golf_party.model.course.Half m = (com.xhills.golf_party.model.course.Half) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        if(m.getCourseRef() != null && m.getCourseRef().getKey() != null){
            writer.setNextPropertyName("courseRef");
            encoder0.encode(writer, m.getCourseRef(), maxDepth, currentDepth);
        }
        if(m.getHoleRef() != null){
            writer.setNextPropertyName("holeRef");
            encoder0.encode(writer, m.getHoleRef());
        }
        if(m.getKey() != null){
            writer.setNextPropertyName("key");
            encoder0.encode(writer, m.getKey());
        }
        if(m.getName() != null){
            writer.setNextPropertyName("name");
            encoder0.encode(writer, m.getName());
        }
        if(m.getVersion() != null){
            writer.setNextPropertyName("version");
            encoder0.encode(writer, m.getVersion());
        }
        writer.endObject();
    }

    @Override
    protected com.xhills.golf_party.model.course.Half jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        com.xhills.golf_party.model.course.Half m = new com.xhills.golf_party.model.course.Half();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("courseRef");
        decoder0.decode(reader, m.getCourseRef(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("holeRef");
        reader = rootReader.newObjectReader("key");
        m.setKey(decoder0.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("name");
        m.setName(decoder0.decode(reader, m.getName()));
        reader = rootReader.newObjectReader("version");
        m.setVersion(decoder0.decode(reader, m.getVersion()));
        return m;
    }
}