package com.xhills.golf_party.meta.round;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2011-09-25 15:30:01")
/** */
public final class RoundGroupMeta extends org.slim3.datastore.ModelMeta<com.xhills.golf_party.model.round.RoundGroup> {

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.xhills.golf_party.model.round.RoundGroup, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<com.xhills.golf_party.model.round.RoundGroup, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<com.xhills.golf_party.model.round.RoundGroup, org.slim3.datastore.ModelRef<com.xhills.golf_party.model.round.Round>, com.xhills.golf_party.model.round.Round> roundRef = new org.slim3.datastore.ModelRefAttributeMeta<com.xhills.golf_party.model.round.RoundGroup, org.slim3.datastore.ModelRef<com.xhills.golf_party.model.round.Round>, com.xhills.golf_party.model.round.Round>(this, "roundRef", "roundRef", org.slim3.datastore.ModelRef.class, com.xhills.golf_party.model.round.Round.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.xhills.golf_party.model.round.RoundGroup, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<com.xhills.golf_party.model.round.RoundGroup, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final RoundGroupMeta slim3_singleton = new RoundGroupMeta();

    /**
     * @return the singleton
     */
    public static RoundGroupMeta get() {
       return slim3_singleton;
    }

    /** */
    public RoundGroupMeta() {
        super("RoundGroup", com.xhills.golf_party.model.round.RoundGroup.class);
    }

    @Override
    public com.xhills.golf_party.model.round.RoundGroup entityToModel(com.google.appengine.api.datastore.Entity entity) {
        com.xhills.golf_party.model.round.RoundGroup model = new com.xhills.golf_party.model.round.RoundGroup();
        model.setKey(entity.getKey());
        if (model.getRoundRef() == null) {
            throw new NullPointerException("The property(roundRef) is null.");
        }
        model.getRoundRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("roundRef"));
        model.setVersion((java.lang.Long) entity.getProperty("version"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        com.xhills.golf_party.model.round.RoundGroup m = (com.xhills.golf_party.model.round.RoundGroup) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        if (m.getRoundRef() == null) {
            throw new NullPointerException("The property(roundRef) must not be null.");
        }
        entity.setProperty("roundRef", m.getRoundRef().getKey());
        entity.setProperty("version", m.getVersion());
        entity.setProperty("slim3.schemaVersion", 1);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        com.xhills.golf_party.model.round.RoundGroup m = (com.xhills.golf_party.model.round.RoundGroup) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        com.xhills.golf_party.model.round.RoundGroup m = (com.xhills.golf_party.model.round.RoundGroup) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        com.xhills.golf_party.model.round.RoundGroup m = (com.xhills.golf_party.model.round.RoundGroup) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
        com.xhills.golf_party.model.round.RoundGroup m = (com.xhills.golf_party.model.round.RoundGroup) model;
        if (m.getRoundRef() == null) {
            throw new NullPointerException("The property(roundRef) must not be null.");
        }
        m.getRoundRef().assignKeyIfNecessary(ds);
    }

    @Override
    protected void incrementVersion(Object model) {
        com.xhills.golf_party.model.round.RoundGroup m = (com.xhills.golf_party.model.round.RoundGroup) model;
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
        com.xhills.golf_party.model.round.RoundGroup m = (com.xhills.golf_party.model.round.RoundGroup) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        if(m.getKey() != null){
            writer.setNextPropertyName("key");
            encoder0.encode(writer, m.getKey());
        }
        if(m.getRoundMemberRef() != null){
            writer.setNextPropertyName("roundMemberRef");
            encoder0.encode(writer, m.getRoundMemberRef());
        }
        if(m.getRoundRef() != null && m.getRoundRef().getKey() != null){
            writer.setNextPropertyName("roundRef");
            encoder0.encode(writer, m.getRoundRef(), maxDepth, currentDepth);
        }
        if(m.getVersion() != null){
            writer.setNextPropertyName("version");
            encoder0.encode(writer, m.getVersion());
        }
        writer.endObject();
    }

    @Override
    protected com.xhills.golf_party.model.round.RoundGroup jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        com.xhills.golf_party.model.round.RoundGroup m = new com.xhills.golf_party.model.round.RoundGroup();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("key");
        m.setKey(decoder0.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("roundMemberRef");
        reader = rootReader.newObjectReader("roundRef");
        decoder0.decode(reader, m.getRoundRef(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("version");
        m.setVersion(decoder0.decode(reader, m.getVersion()));
        return m;
    }
}