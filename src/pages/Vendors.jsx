import { useState, useEffect } from 'react';
import { Plus, Search, Edit2, Trash2, FileText, Star } from 'lucide-react';
import api from '../api/axios';
import './Vendors.css';

export default function Vendors() {
  const [vendors, setVendors] = useState([]);
  const [loading, setLoading] = useState(true);
  const [searchTerm, setSearchTerm] = useState('');
  const [showModal, setShowModal] = useState(false);
  const [creating, setCreating] = useState(false);
  const [formData, setFormData] = useState({
    companyName: '',
    contactPerson: '',
    email: '',
    phone: '',
    gstNumber: ''
  });

  useEffect(() => {
    fetchVendors();
  }, []);

  const fetchVendors = async () => {
    try {
      setLoading(true);
      const response = await api.get('/vendors');
      setVendors(response.data || []);
    } catch (error) {
      console.error("Error fetching vendors:", error);
    } finally {
      setLoading(false);
    }
  };

  const handleCreateVendor = async (e) => {
    e.preventDefault();
    try {
      setCreating(true);
      await api.post('/vendors', formData);
      setShowModal(false);
      setFormData({ companyName: '', contactPerson: '', email: '', phone: '', gstNumber: '' });
      fetchVendors(); // refresh list
    } catch (error) {
      console.error("Error creating vendor:", error);
      alert("Failed to create Vendor");
    } finally {
      setCreating(false);
    }
  };

  const filteredVendors = vendors.filter(v => 
    v.vendorName?.toLowerCase().includes(searchTerm.toLowerCase()) ||
    v.email?.toLowerCase().includes(searchTerm.toLowerCase())
  );

  return (
    <div className="page-container">
      <div className="page-header">
        <div>
          <h1 className="title-gradient" style={{ fontSize: '2rem' }}>Vendor Management</h1>
          <p style={{ color: 'var(--text-secondary)' }}>Manage your suppliers, view their ratings, and access documents.</p>
        </div>
        <button className="btn btn-primary" onClick={() => setShowModal(true)}>
          <Plus size={18} /> Add Vendor
        </button>
      </div>

      <div className="glass-panel vendors-content">
        <div className="table-controls">
          <div className="search-box">
            <Search size={18} className="search-icon" />
            <input 
              type="text" 
              placeholder="Search vendors..." 
              className="input-base"
              value={searchTerm}
              onChange={(e) => setSearchTerm(e.target.value)}
              style={{ paddingLeft: '2.5rem' }}
            />
          </div>
        </div>

        {loading ? (
          <div className="loading-state">Loading vendors...</div>
        ) : (
          <div className="table-container">
            <table className="table">
              <thead>
                <tr>
                  <th>Vendor ID</th>
                  <th>Name</th>
                  <th>Contact Info</th>
                  <th>Address</th>
                  <th style={{ textAlign: 'right' }}>Actions</th>
                </tr>
              </thead>
              <tbody>
                {filteredVendors.length > 0 ? filteredVendors.map(vendor => (
                  <tr key={vendor.vendorId}>
                    <td style={{ color: 'var(--text-secondary)' }}>#{vendor.vendorId}</td>
                    <td style={{ fontWeight: 500 }}>{vendor.vendorName}</td>
                    <td>
                      <div>{vendor.email}</div>
                      <div style={{ fontSize: '0.75rem', color: 'var(--text-secondary)' }}>{vendor.phone}</div>
                    </td>
                    <td style={{ maxWidth: '200px', whiteSpace: 'nowrap', overflow: 'hidden', textOverflow: 'ellipsis' }}>
                      {vendor.address}
                    </td>
                    <td>
                      <div className="action-buttons">
                        <button className="icon-btn" title="View Documents"><FileText size={18} /></button>
                        <button className="icon-btn" title="Ratings"><Star size={18} /></button>
                        <button className="icon-btn" title="Edit"><Edit2 size={18} /></button>
                        <button className="icon-btn danger" title="Delete"><Trash2 size={18} /></button>
                      </div>
                    </td>
                  </tr>
                )) : (
                  <tr>
                    <td colSpan="5" style={{ textAlign: 'center', padding: '3rem', color: 'var(--text-secondary)' }}>
                      No vendors found. Try adding a new one.
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
              <h2>Add New Vendor</h2>
              <button className="icon-btn" onClick={() => setShowModal(false)}>X</button>
            </div>
            <form onSubmit={handleCreateVendor} className="modal-body">
              <div className="form-group">
                <label>Company/Vendor Name</label>
                <input 
                  type="text" 
                  className="input-base" 
                  value={formData.companyName}
                  onChange={(e) => setFormData({...formData, companyName: e.target.value})}
                  required 
                />
              </div>
              <div className="form-group">
                <label>Contact Person</label>
                <input 
                  type="text" 
                  className="input-base" 
                  value={formData.contactPerson}
                  onChange={(e) => setFormData({...formData, contactPerson: e.target.value})}
                  required 
                />
              </div>
              <div className="form-group">
                <label>Email Address</label>
                <input 
                  type="email" 
                  className="input-base" 
                  value={formData.email}
                  onChange={(e) => setFormData({...formData, email: e.target.value})}
                  required 
                />
              </div>
              <div style={{ display: 'flex', gap: '1rem' }}>
                <div className="form-group" style={{ flex: 1 }}>
                  <label>Phone Number</label>
                  <input 
                    type="text" 
                    className="input-base" 
                    value={formData.phone}
                    onChange={(e) => setFormData({...formData, phone: e.target.value})}
                    required 
                  />
                </div>
                <div className="form-group" style={{ flex: 1 }}>
                  <label>GST Number</label>
                  <input 
                    type="text" 
                    className="input-base" 
                    value={formData.gstNumber}
                    onChange={(e) => setFormData({...formData, gstNumber: e.target.value})}
                  />
                </div>
              </div>
              <div className="modal-footer" style={{ marginTop: '2rem', display: 'flex', justifyContent: 'flex-end', gap: '1rem' }}>
                <button type="button" className="btn btn-secondary" onClick={() => setShowModal(false)}>Cancel</button>
                <button type="submit" className="btn btn-primary" disabled={creating}>
                  {creating ? 'Adding...' : 'Add Vendor'}
                </button>
              </div>
            </form>
          </div>
        </div>
      )}
    </div>
  );
}
