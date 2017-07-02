package com.djunderworld.nongjik.entity;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QItemCategory is a Querydsl query type for ItemCategory
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QItemCategory extends EntityPathBase<ItemCategory> {

    private static final long serialVersionUID = -1072538433L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QItemCategory itemCategory = new QItemCategory("itemCategory");

    public final QBase _super = new QBase(this);

    public final QCategory category;

    //inherited
    public final StringPath createdAt = _super.createdAt;

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath name = createString("name");

    public final ListPath<Story, QStory> stories = this.<Story, QStory>createList("stories", Story.class, QStory.class, PathInits.DIRECT2);

    //inherited
    public final StringPath updatedAt = _super.updatedAt;

    public QItemCategory(String variable) {
        this(ItemCategory.class, forVariable(variable), INITS);
    }

    public QItemCategory(Path<? extends ItemCategory> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QItemCategory(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QItemCategory(PathMetadata<?> metadata, PathInits inits) {
        this(ItemCategory.class, metadata, inits);
    }

    public QItemCategory(Class<? extends ItemCategory> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.category = inits.isInitialized("category") ? new QCategory(forProperty("category")) : null;
    }

}

