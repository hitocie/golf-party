package com.xhills.golf_party.meta.me;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2011-10-31 23:54:23")
/** */
public final class GroupMeta extends org.slim3.datastore.ModelMeta<com.xhills.golf_party.model.me.Group> {

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.xhills.golf_party.model.me.Group, java.lang.Long> groupid = new org.slim3.datastore.CoreAttributeMeta<com.xhills.golf_party.model.me.Group, java.lang.Long>(this, "groupid", "groupid", long.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.xhills.golf_party.model.me.Group, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<com.xhills.golf_party.model.me.Group, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.xhills.golf_party.model.me.Group> name = new org.slim3.datastore.StringAttributeMeta<com.xhills.golf_party.model.me.Group>(this, "name", "name");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.xhills.golf_party.model.me.Group> ownerid = new org.slim3.datastore.StringAttributeMeta<com.xhills.golf_party.model.me.Group>(this, "ownerid", "ownerid");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.xhills.golf_party.model.me.Group, java.util.Date> timestamp = new org.slim3.datastore.CoreAttributeMeta<com.xhills.golf_party.model.me.Group, java.util.Date>(this, "timestamp", "timestamp", java.util.Date.class);

    /** */
    public final org.slim3.datastore.StringCollectionUnindexedAttributeMeta<com.xhills.golf_party.model.me.Group, java.util.Set<java.lang.String>> userids = new org.slim3.datastore.StringCollectionUnindexedAttributeMeta<com.xhills.golf_party.model.me.Group, java.util.Set<java.lang.String>>(this, "userids", "userids", java.util.Set.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.xhills.golf_party.model.me.Group, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<com.xhills.golf_party.model.me.Group, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final GroupMeta slim3_singleton = new GroupMeta();

    /**
     * @return the singleton
     */
    public static GroupMeta get() {
       return slim3_singleton;
    }

    /** */
    public GroupMeta() {
        super("Group", com.xhills.golf_party.model.me.Group.class);
    }

    @Override
    public com.xhills.golf_party.model.me.Group entityToModel(com.google.appengine.api.datastore.Entity entity) {
        com.xhills.golf_party.model.me.Group model = new com.xhills.golf_party.model.me.Group();
        model.setGroupid(longToPrimitiveLong((java.lang.Long) entity.getProperty("groupid")));
        model.setKey(entity.getKey());
        model.setName((java.lang.String) entity.getProperty("name"));
        model.setOwnerid((java.lang.String) entity.getProperty("ownerid"));
        model.setTimestamp((java.util.Date) entity.getProperty("timestamp"));
        model.setUserids(new java.util.HashSet<java.lang.String>(toList(java.lang.String.class, entity.getProperty("userids"))));
        model.setVersion((java.lang.Long) entity.getProperty("version"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        com.xhills.golf_party.model.me.Group m = (com.xhills.golf_party.model.me.Group) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("groupid", m.getGroupid());
        entity.setProperty("name", m.getName());
        entity.setProperty("ownerid", m.getOwnerid());
        entity.setProperty("timestamp", m.getTimestamp());
        entity.setUnindexedProperty("userids", m.getUserids());
        entity.setProperty("version", m.getVersion());
        entity.setProperty("slim3.schemaVersion", 1);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        com.xhills.golf_party.model.me.Group m = (com.xhills.golf_party.model.me.Group) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        com.xhills.golf_party.model.me.Group m = (com.xhills.golf_party.model.me.Group) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        com.xhills.golf_party.model.me.Group m = (com.xhills.golf_party.model.me.Group) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
    }

    @Override
    protected void incrementVersion(Object model) {
        com.xhills.golf_party.model.me.Group m = (com.xhills.golf_party.model.me.Group) model;
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
        com.xhills.golf_party.model.me.Group m = (com.xhills.golf_party.model.me.Group) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        writer.setNextPropertyName("groupid");
        encoder0.encode(writer, m.getGroupid());
        if(m.getKey() != null){
            writer.setNextPropertyName("key");
            encoder0.encode(writer, m.getKey());
        }
        if(m.getName() != null){
            writer.setNextPropertyName("name");
            encoder0.encode(writer, m.getName());
        }
        if(m.getOwnerid() != null){
            writer.setNextPropertyName("ownerid");
            encoder0.encode(writer, m.getOwnerid());
        }
        if(m.getTimestamp() != null){
            writer.setNextPropertyName("timestamp");
            encoder0.encode(writer, m.getTimestamp());
        }
        if(m.getUserids() != null){
            writer.setNextPropertyName("userids");
            writer.beginArray();
            for(java.lang.String v : m.getUserids()){
                encoder0.encode(writer, v);
            }
            writer.endArray();
        }
        if(m.getVersion() != null){
            writer.setNextPropertyName("version");
            encoder0.encode(writer, m.getVersion());
        }
        writer.endObject();
    }

    @Override
    protected com.xhills.golf_party.model.me.Group jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        com.xhills.golf_party.model.me.Group m = new com.xhills.golf_party.model.me.Group();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("groupid");
        m.setGroupid(decoder0.decode(reader, m.getGroupid()));
        reader = rootReader.newObjectReader("key");
        m.setKey(decoder0.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("name");
        m.setName(decoder0.decode(reader, m.getName()));
        reader = rootReader.newObjectReader("ownerid");
        m.setOwnerid(decoder0.decode(reader, m.getOwnerid()));
        reader = rootReader.newObjectReader("timestamp");
        m.setTimestamp(decoder0.decode(reader, m.getTimestamp()));
        reader = rootReader.newObjectReader("userids");
        {
            java.util.HashSet<java.lang.String> elements = new java.util.HashSet<java.lang.String>();
            org.slim3.datastore.json.JsonArrayReader r = rootReader.newArrayReader("userids");
            if(r != null){
                reader = r;
                int n = r.length();
                for(int i = 0; i < n; i++){
                    r.setIndex(i);
                    java.lang.String v = decoder0.decode(reader, (java.lang.String)null)                    ;
                    if(v != null){
                        elements.add(v);
                    }
                }
                m.setUserids(elements);
            }
        }
        reader = rootReader.newObjectReader("version");
        m.setVersion(decoder0.decode(reader, m.getVersion()));
        return m;
    }
}