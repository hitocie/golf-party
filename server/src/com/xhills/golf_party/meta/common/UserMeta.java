package com.xhills.golf_party.meta.common;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2011-09-25 18:01:00")
/** */
public final class UserMeta extends org.slim3.datastore.ModelMeta<com.xhills.golf_party.model.common.User> {

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.xhills.golf_party.model.common.User, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<com.xhills.golf_party.model.common.User, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.xhills.golf_party.model.common.User, java.util.Date> timestamp = new org.slim3.datastore.CoreAttributeMeta<com.xhills.golf_party.model.common.User, java.util.Date>(this, "timestamp", "timestamp", java.util.Date.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.xhills.golf_party.model.common.User> token = new org.slim3.datastore.StringAttributeMeta<com.xhills.golf_party.model.common.User>(this, "token", "token");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.xhills.golf_party.model.common.User> userid = new org.slim3.datastore.StringAttributeMeta<com.xhills.golf_party.model.common.User>(this, "userid", "userid");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.xhills.golf_party.model.common.User> username = new org.slim3.datastore.StringAttributeMeta<com.xhills.golf_party.model.common.User>(this, "username", "username");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.xhills.golf_party.model.common.User, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<com.xhills.golf_party.model.common.User, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final UserMeta slim3_singleton = new UserMeta();

    /**
     * @return the singleton
     */
    public static UserMeta get() {
       return slim3_singleton;
    }

    /** */
    public UserMeta() {
        super("User", com.xhills.golf_party.model.common.User.class);
    }

    @Override
    public com.xhills.golf_party.model.common.User entityToModel(com.google.appengine.api.datastore.Entity entity) {
        com.xhills.golf_party.model.common.User model = new com.xhills.golf_party.model.common.User();
        model.setKey(entity.getKey());
        model.setTimestamp((java.util.Date) entity.getProperty("timestamp"));
        model.setToken((java.lang.String) entity.getProperty("token"));
        model.setUserid((java.lang.String) entity.getProperty("userid"));
        model.setUsername((java.lang.String) entity.getProperty("username"));
        model.setVersion((java.lang.Long) entity.getProperty("version"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        com.xhills.golf_party.model.common.User m = (com.xhills.golf_party.model.common.User) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("timestamp", m.getTimestamp());
        entity.setProperty("token", m.getToken());
        entity.setProperty("userid", m.getUserid());
        entity.setProperty("username", m.getUsername());
        entity.setProperty("version", m.getVersion());
        entity.setProperty("slim3.schemaVersion", 1);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        com.xhills.golf_party.model.common.User m = (com.xhills.golf_party.model.common.User) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        com.xhills.golf_party.model.common.User m = (com.xhills.golf_party.model.common.User) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        com.xhills.golf_party.model.common.User m = (com.xhills.golf_party.model.common.User) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
    }

    @Override
    protected void incrementVersion(Object model) {
        com.xhills.golf_party.model.common.User m = (com.xhills.golf_party.model.common.User) model;
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
        com.xhills.golf_party.model.common.User m = (com.xhills.golf_party.model.common.User) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        if(m.getKey() != null){
            writer.setNextPropertyName("key");
            encoder0.encode(writer, m.getKey());
        }
        if(m.getTimestamp() != null){
            writer.setNextPropertyName("timestamp");
            encoder0.encode(writer, m.getTimestamp());
        }
        if(m.getToken() != null){
            writer.setNextPropertyName("token");
            encoder0.encode(writer, m.getToken());
        }
        if(m.getUserid() != null){
            writer.setNextPropertyName("userid");
            encoder0.encode(writer, m.getUserid());
        }
        if(m.getUsername() != null){
            writer.setNextPropertyName("username");
            encoder0.encode(writer, m.getUsername());
        }
        if(m.getVersion() != null){
            writer.setNextPropertyName("version");
            encoder0.encode(writer, m.getVersion());
        }
        writer.endObject();
    }

    @Override
    protected com.xhills.golf_party.model.common.User jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        com.xhills.golf_party.model.common.User m = new com.xhills.golf_party.model.common.User();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("key");
        m.setKey(decoder0.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("timestamp");
        m.setTimestamp(decoder0.decode(reader, m.getTimestamp()));
        reader = rootReader.newObjectReader("token");
        m.setToken(decoder0.decode(reader, m.getToken()));
        reader = rootReader.newObjectReader("userid");
        m.setUserid(decoder0.decode(reader, m.getUserid()));
        reader = rootReader.newObjectReader("username");
        m.setUsername(decoder0.decode(reader, m.getUsername()));
        reader = rootReader.newObjectReader("version");
        m.setVersion(decoder0.decode(reader, m.getVersion()));
        return m;
    }
}