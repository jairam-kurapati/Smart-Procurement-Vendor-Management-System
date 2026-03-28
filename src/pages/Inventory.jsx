import { useState, useEffect } from 'react';
import { Plus, Search, PackageOpen, AlertTriangle } from 'lucide-react';
import api from '../api/axios';

export default function Inventory() {
  const [items, setItems] = useState([]);
  const [loading, setLoading] = useState(true);
  const [showModal, setShowModal] = useState(false);
  const [creating, setCreating] = useState(false);
  const [formData, setFormData] = useState({
    itemName: '',
    category: '',
    price: ''
  });

  useEffect(() => {
    fetchItems();
  }, []);

  const fetchItems = async () => {
    try {
      setLoading(true);
      const response = await api.get('/items');
      setItems(response.data || []);
    } catch (error) {
      console.error("Error fetching items:", error);
    } finally {
      setLoading(false);
    }
  };

  const handleCreateItem = async (e) => {
    e.preventDefault();
    try {
      setCreating(true);
      await api.post('/items', {
        itemName: formData.itemName,
        category: formData.category,
        price: parseFloat(formData.price)
      });
      setShowModal(false);
      setFormData({ itemName: '', category: '', price: '' });
      fetchItems();
    } catch (error) {
      console.error("Error creating item:", error);
      alert("Failed to create Item");
    } finally {
      setCreating(false);
    }
  };

  return (
    <div className="page-container">
      <div className="page-header">
        <div>
          <h1 className="title-gradient" style={{ fontSize: '2rem' }}>Inventory Management</h1>
          <p style={{ color: 'var(--text-secondary)' }}>Track stock levels, categories, and item catalog.</p>
        </div>
        <button className="btn btn-primary" onClick={() => setShowModal(true)}>
          <Plus size={18} /> Add Item
        </button>
      </div>

      <div className="glass-panel vendors-content">
        <div className="table-controls">
          <div className="search-box">
            <Search size={18} className="search-icon" />
            <input 
              type="text" 
              placeholder="Search items..." 
              className="input-base"
              style={{ paddingLeft: '2.5rem' }}
            />
          </div>
        </div>

        {loading ? (
          <div className="loading-state">Loading inventory...</div>
        ) : (
          <div className="table-container">
            <table className="table">
              <thead>
                <tr>
                  <th>Item Name</th>
                  <th>Category</th>
                  <th>Unit Price</th>
                  <th>Quantity in Stock</th>
                  <th>Reorder Level</th>
                  <th style={{ textAlign: 'right' }}>Status</th>
                </tr>
              </thead>
              <tbody>
                {items.length > 0 ? items.map(item => (
                  <tr key={item.itemId}>
                    <td style={{ fontWeight: 500 }}>
                      <div style={{ display: 'flex', alignItems: 'center', gap: '0.5rem' }}>
                        <PackageOpen size={16} color="var(--primary)" />
                        {item.itemName}
                      </div>
                    </td>
                    <td>{item.category || 'General'}</td>
                    <td>${item.price?.toFixed(2) || item.unitPrice?.toFixed(2) || '0.00'}</td>
                    <td style={{ fontWeight: 600 }}>{item.quantityInStock || 0}</td>
                    <td>{item.reorderLevel || 'N/A'}</td>
                    <td style={{ textAlign: 'right' }}>
                      {(item.quantityInStock || 0) <= (item.reorderLevel || 0) ? (
                        <span className="badge badge-danger" style={{ display: 'inline-flex', gap: '4px' }}>
                          <AlertTriangle size={12} /> Low Stock
                        </span>
                      ) : (
                        <span className="badge badge-success">In Stock</span>
                      )}
                    </td>
                  </tr>
                )) : (
                  <tr>
                    <td colSpan="6" style={{ textAlign: 'center', padding: '3rem', color: 'var(--text-secondary)' }}>
                      No inventory items found. Add some to continue.
                    </td>
                  </tr>
                )}
              </tbody>
            </table>
          </div>
        )}
      </div>

      {showModal && (
        <div className="modal-overlay" onClick={() => setShowModal(false)}>
          <div className="modal-content glass-panel" onClick={e => e.stopPropagation()}>
            <div className="modal-header">
              <h2>Add New Catalog Item</h2>
              <button className="icon-btn" onClick={() => setShowModal(false)}>X</button>
            </div>
            <form onSubmit={handleCreateItem} className="modal-body">
              <div className="form-group">
                <label>Item Name</label>
                <input 
                  type="text" 
                  className="input-base" 
                  value={formData.itemName}
                  onChange={(e) => setFormData({...formData, itemName: e.target.value})}
                  required 
                />
              </div>
              <div className="form-group">
                <label>Category</label>
                <input 
                  type="text" 
                  className="input-base" 
                  value={formData.category}
                  onChange={(e) => setFormData({...formData, category: e.target.value})}
                  required 
                />
              </div>
              <div className="form-group">
                <label>Unit Price ($)</label>
                <input 
                  type="number" 
                  step="0.01"
                  className="input-base" 
                  value={formData.price}
                  onChange={(e) => setFormData({...formData, price: e.target.value})}
                  required 
                />
              </div>
              <div className="modal-footer" style={{ marginTop: '2rem', display: 'flex', justifyContent: 'flex-end', gap: '1rem' }}>
                <button type="button" className="btn btn-secondary" onClick={() => setShowModal(false)}>Cancel</button>
                <button type="submit" className="btn btn-primary" disabled={creating}>
                  {creating ? 'Adding...' : 'Add Item'}
                </button>
              </div>
            </form>
          </div>
        </div>
      )}
    </div>
  );
}
