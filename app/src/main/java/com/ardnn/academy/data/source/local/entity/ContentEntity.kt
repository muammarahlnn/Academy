package com.ardnn.academy.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity

data class ContentEntity(
    @ColumnInfo(name = "content")
    var content: String?
)