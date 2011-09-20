package com.xhills.golf_party.meta.round;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2011-09-20 23:02:08")
/** */
public final class RoundMemberMeta extends org.slim3.datastore.ModelMeta<com.xhills.golf_party.model.round.RoundMember> {

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.xhills.golf_party.model.round.RoundMember, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<com.xhills.golf_party.model.round.RoundMember, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<com.xhills.golf_party.model.round.RoundMember, org.slim3.datastore.ModelRef<com.xhills.golf_party.model.round.RoundGroup>, com.xhills.golf_party.model.round.RoundGroup> roundGroupRef = new org.slim3.datastore.ModelRefAttributeMeta<com.xhills.golf_party.model.round.RoundMember, org.slim3.datastore.ModelRef<com.xhills.golf_party.model.round.RoundGroup>, com.xhills.golf_party.model.round.RoundGroup>(this, "roundGroupRef", "roundGroupRef", org.slim3.datastore.ModelRef.class, com.xhills.golf_party.model.round.RoundGroup.class);

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<com.xhills.golf_party.model.round.RoundMember, org.slim3.datastore.ModelRef<com.xhills.golf_party.model.common.User>, com.xhills.golf_party.model.common.User> userRef = new org.slim3.datastore.ModelRefAttributeMeta<com.xhills.golf_party.model.round.RoundMember, org.slim3.datastore.ModelRef<com.xhills.golf_party.model.common.User>, com.xhills.golf_party.model.common.User>(this, "userRef", "userRef", org.slim3.datastore.ModelRef.class, com.xhills.golf_party.model.common.User.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.xhills.golf_party.model.round.RoundMember, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<com.xhills.golf_party.model.round.RoundMember, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final RoundMemberMeta slim3_singleton = new RoundMemberMeta();

    /**
     * @return the singleton
     */
    public static RoundMemberMeta get() {
       return slim3_singleton;
    }

    /** */
    public RoundMemberMeta() {
        super("RoundMember", com.xhills.golf_party.model.round.RoundMember.class);
    }

    @Override
    public com.xhills.golf_party.model.round.RoundMember entityToModel(com.google.appengine.api.datastore.Entity entity) {
        com.xhills.golf_party.model.round.RoundMember model = new com.xhills.golf_party.model.round.RoundMember();
        model.setKey(entity.getKey());
        if (model.getRoundGroupRef() == null) {
            throw new NullPointerException("The property(roundGroupRef) is null.");
        }
        model.getRoundGroupRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("roundGroupRef"));
        java.util.List<com.xhills.golf_party.common.round.Score> _scores = blobToSerializable((com.google.appengine.api.datastore.Blob) entity.getProperty("scores"));
        model.setScores(_scores);
        if (model.getUserRef() == null) {
            throw new NullPointerException("The property(userRef) is null.");
        }
        model.getUserRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("userRef"));
        model.setVersion((java.lang.Long) entity.getProperty("version"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        com.xhills.golf_party.model.round.RoundMember m = (com.xhills.golf_party.model.round.RoundMember) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        if (m.getRoundGroupRef() == null) {
            throw new NullPointerException("The property(roundGroupRef) must not be null.");
        }
        entity.setProperty("roundGroupRef", m.getRoundGroupRef().getKey());
        entity.setUnindexedProperty("scores", serializableToBlob(m.getScores()));
        if (m.getUserRef() == null) {
            throw new NullPointerException("The property(userRef) must not be null.");
        }
        entity.setProperty("userRef", m.getUserRef().getKey());
        entity.setProperty("version", m.getVersion());
        entity.setProperty("slim3.schemaVersion", 1);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        com.xhills.golf_party.model.round.RoundMember m = (com.xhills.golf_party.model.round.RoundMember) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        com.xhills.golf_party.model.round.RoundMember m = (com.xhills.golf_party.model.round.RoundMember) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        com.xhills.golf_party.model.round.RoundMember m = (com.xhills.golf_party.model.round.RoundMember) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
        com.xhills.golf_party.model.round.RoundMember m = (com.xhills.golf_party.model.round.RoundMember) model;
        if (m.getRoundGroupRef() == null) {
            throw new NullPointerException("The property(roundGroupRef) must not be null.");
        }
        m.getRoundGroupRef().assignKeyIfNecessary(ds);
        if (m.getUserRef() == null) {
            throw new NullPointerException("The property(userRef) must not be null.");
        }
        m.getUserRef().assignKeyIfNecessary(ds);
    }

    @Override
    protected void incrementVersion(Object model) {
        com.xhills.golf_party.model.round.RoundMember m = (com.xhills.golf_party.model.round.RoundMember) model;
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
        com.xhills.golf_party.model.round.RoundMember m = (com.xhills.golf_party.model.round.RoundMember) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        if(m.getKey() != null){
            writer.setNextPropertyName("key");
            encoder0.encode(writer, m.getKey());
        }
        if(m.getRoundGroupRef() != null && m.getRoundGroupRef().getKey() != null){
            writer.setNextPropertyName("roundGroupRef");
            encoder0.encode(writer, m.getRoundGroupRef(), maxDepth, currentDepth);
        }
        if(m.getScores() != null){
            writer.setNextPropertyName("scores");
            // com.xhills.golf_party.common.round.Score is not supported.
        }
        if(m.getUserRef() != null && m.getUserRef().getKey() != null){
            writer.setNextPropertyName("userRef");
            encoder0.encode(writer, m.getUserRef(), maxDepth, currentDepth);
        }
        if(m.getVersion() != null){
            writer.setNextPropertyName("version");
            encoder0.encode(writer, m.getVersion());
        }
        writer.endObject();
    }

    @Override
    protected com.xhills.golf_party.model.round.RoundMember jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        com.xhills.golf_party.model.round.RoundMember m = new com.xhills.golf_party.model.round.RoundMember();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("key");
        m.setKey(decoder0.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("roundGroupRef");
        decoder0.decode(reader, m.getRoundGroupRef(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("scores");
        reader = rootReader.newObjectReader("userRef");
        decoder0.decode(reader, m.getUserRef(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("version");
        m.setVersion(decoder0.decode(reader, m.getVersion()));
        return m;
    }
}