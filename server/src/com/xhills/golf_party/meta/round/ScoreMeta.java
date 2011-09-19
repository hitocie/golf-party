package com.xhills.golf_party.meta.round;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2011-09-16 15:15:55")
/** */
public final class ScoreMeta extends org.slim3.datastore.ModelMeta<com.xhills.golf_party.model.round.Score> {

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.xhills.golf_party.model.round.Score, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<com.xhills.golf_party.model.round.Score, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.xhills.golf_party.model.round.Score, java.lang.Integer> putter = new org.slim3.datastore.CoreAttributeMeta<com.xhills.golf_party.model.round.Score, java.lang.Integer>(this, "putter", "putter", int.class);

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<com.xhills.golf_party.model.round.Score, org.slim3.datastore.ModelRef<com.xhills.golf_party.model.round.RoundMember>, com.xhills.golf_party.model.round.RoundMember> roundMemberRef = new org.slim3.datastore.ModelRefAttributeMeta<com.xhills.golf_party.model.round.Score, org.slim3.datastore.ModelRef<com.xhills.golf_party.model.round.RoundMember>, com.xhills.golf_party.model.round.RoundMember>(this, "roundMemberRef", "roundMemberRef", org.slim3.datastore.ModelRef.class, com.xhills.golf_party.model.round.RoundMember.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.xhills.golf_party.model.round.Score, java.lang.Integer> score = new org.slim3.datastore.CoreAttributeMeta<com.xhills.golf_party.model.round.Score, java.lang.Integer>(this, "score", "score", int.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.xhills.golf_party.model.round.Score, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<com.xhills.golf_party.model.round.Score, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final ScoreMeta slim3_singleton = new ScoreMeta();

    /**
     * @return the singleton
     */
    public static ScoreMeta get() {
       return slim3_singleton;
    }

    /** */
    public ScoreMeta() {
        super("Score", com.xhills.golf_party.model.round.Score.class);
    }

    @Override
    public com.xhills.golf_party.model.round.Score entityToModel(com.google.appengine.api.datastore.Entity entity) {
        com.xhills.golf_party.model.round.Score model = new com.xhills.golf_party.model.round.Score();
        model.setKey(entity.getKey());
        model.setPutter(longToPrimitiveInt((java.lang.Long) entity.getProperty("putter")));
        if (model.getRoundMemberRef() == null) {
            throw new NullPointerException("The property(roundMemberRef) is null.");
        }
        model.getRoundMemberRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("roundMemberRef"));
        model.setScore(longToPrimitiveInt((java.lang.Long) entity.getProperty("score")));
        model.setVersion((java.lang.Long) entity.getProperty("version"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        com.xhills.golf_party.model.round.Score m = (com.xhills.golf_party.model.round.Score) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("putter", m.getPutter());
        if (m.getRoundMemberRef() == null) {
            throw new NullPointerException("The property(roundMemberRef) must not be null.");
        }
        entity.setProperty("roundMemberRef", m.getRoundMemberRef().getKey());
        entity.setProperty("score", m.getScore());
        entity.setProperty("version", m.getVersion());
        entity.setProperty("slim3.schemaVersion", 1);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        com.xhills.golf_party.model.round.Score m = (com.xhills.golf_party.model.round.Score) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        com.xhills.golf_party.model.round.Score m = (com.xhills.golf_party.model.round.Score) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        com.xhills.golf_party.model.round.Score m = (com.xhills.golf_party.model.round.Score) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
        com.xhills.golf_party.model.round.Score m = (com.xhills.golf_party.model.round.Score) model;
        if (m.getRoundMemberRef() == null) {
            throw new NullPointerException("The property(roundMemberRef) must not be null.");
        }
        m.getRoundMemberRef().assignKeyIfNecessary(ds);
    }

    @Override
    protected void incrementVersion(Object model) {
        com.xhills.golf_party.model.round.Score m = (com.xhills.golf_party.model.round.Score) model;
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
        com.xhills.golf_party.model.round.Score m = (com.xhills.golf_party.model.round.Score) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        if(m.getKey() != null){
            writer.setNextPropertyName("key");
            encoder0.encode(writer, m.getKey());
        }
        writer.setNextPropertyName("putter");
        encoder0.encode(writer, m.getPutter());
        if(m.getRoundMemberRef() != null && m.getRoundMemberRef().getKey() != null){
            writer.setNextPropertyName("roundMemberRef");
            encoder0.encode(writer, m.getRoundMemberRef(), maxDepth, currentDepth);
        }
        writer.setNextPropertyName("score");
        encoder0.encode(writer, m.getScore());
        if(m.getVersion() != null){
            writer.setNextPropertyName("version");
            encoder0.encode(writer, m.getVersion());
        }
        writer.endObject();
    }

    @Override
    protected com.xhills.golf_party.model.round.Score jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        com.xhills.golf_party.model.round.Score m = new com.xhills.golf_party.model.round.Score();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("key");
        m.setKey(decoder0.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("putter");
        m.setPutter(decoder0.decode(reader, m.getPutter()));
        reader = rootReader.newObjectReader("roundMemberRef");
        decoder0.decode(reader, m.getRoundMemberRef(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("score");
        m.setScore(decoder0.decode(reader, m.getScore()));
        reader = rootReader.newObjectReader("version");
        m.setVersion(decoder0.decode(reader, m.getVersion()));
        return m;
    }
}